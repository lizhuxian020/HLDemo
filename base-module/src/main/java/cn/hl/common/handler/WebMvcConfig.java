package cn.hl.common.handler;

import cn.hl.common.config.JwtConfig;
import cn.hl.common.constant.SystemConstant;
import cn.hl.common.model.exception.HLReturnCode;
import cn.hl.common.model.exception.HLRunTimeException;
import cn.hl.common.model.jwt.TokenMessage;
import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtConfig jwtConfig;

    /*
     *CORS（跨域资源共享）**是浏览器的一种安全机制，用来防止网页随便请求别人的服务器资源。
     * （CORS，Cross-Origin Resource Sharing）
     * 🚨 浏览器遇到跨域请求时会做什么？
浏览器做两件事：
1. 简单请求（GET/POST+form），直接发出但会检查响应
如果响应里没有 Access-Control-Allow-Origin 等字段，浏览器就会阻止返回结果。
2. 非简单请求（如 DELETE、PUT、POST+JSON）
🔁 浏览器会先自动发一个 OPTIONS 请求，称为预检请求（preflight），问服务器“我能不能访问你？”
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                /*
                这里加这句, 是要web段可以请求delete, 不然会报403forbidden,
                跨域请求，特别是 DELETE、PUT、PATCH、POST（application/json） 请求时，浏览器会自动发送一个 OPTIONS 方法的“预检请求”，问服务器：“我可以发吗？”
如果服务器不正确响应，浏览器就拒绝访问，显示 Invalid CORS request。
                 */
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 允许的方法
//                .allowedOrigins("http://localhost:9002")
        ;
    }

    /*
    参数解析器
    1. 当在Controller上, 指定RequestMapper的方法,
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ServletWebArgumentResolverAdapter(new WebArgumentResolver() {
            @Override
            public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest nativeWebRequest) throws Exception {
                if (methodParameter.getParameterType().equals(TokenMessage.class)) {
                    HttpServletRequest nativeRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
                    String token = nativeRequest.getHeader(SystemConstant.HEADER_TOKEN);
                    if (StringUtils.isEmpty(token)) {
                        throw new HLRunTimeException(HLReturnCode.BASE_TOKEN_UNAUTHORIZED);
                    }
                    Claims claimsByToken = jwtConfig.getClaimsByToken(token);
                    TokenMessage tokenMessage = JSON.parseObject(claimsByToken.getSubject(), TokenMessage.class);
                    return tokenMessage;
                }
                return UNRESOLVED;
            }
        }));
    }
}
