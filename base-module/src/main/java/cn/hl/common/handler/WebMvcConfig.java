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

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
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
