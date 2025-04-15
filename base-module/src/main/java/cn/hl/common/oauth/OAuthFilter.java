package cn.hl.common.oauth;

import cn.hl.common.constant.SystemConstant;
import cn.hl.common.model.CallResult;
import cn.hl.common.model.exception.HLReturnCode;
import cn.hl.common.model.exception.HLRunTimeException;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OAuthFilter extends AuthenticatingFilter {

    /*
    * 一般接口进来, 先走这个方法,
    * 如果返回true, 则直接同意进去, 不需要前置校验, 直接走controller逻辑
    * 如果返回false, 则校验不过, 不继续走逻辑, 直接返回空给你
    * 如果走super, 会判断isAccessAllowed,
    *
    * */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        /*
        * return this.isAccessAllowed(request, response, mappedValue) || this.onAccessDenied(request, response, mappedValue);
        * */
        return super.preHandle(request, response);
    }

    /*
    * *  返回true, 则一样, 校验通过, 走业务逻辑
     *   返回false, 则会判断onAccessDenied
     * 走super逻辑的话, 就判断是否是loginURL, 和是否放任 isPermissive (没研究, 不会, 不管, 大概就是问你是不是loinURL, 并且放不放仁)
     * 我们这不走super, 直接走false.
    * */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    /*
    * 当上面拒绝访问的时候, 就会走accessDenied
    * 没有super实现
    * 这里是最后一关, 返回true, 则通过, 访问业务, false则失败, 返回空
    * 这里不直接返回true or false, 执行login, 表示要走shiro的登录逻辑, 分为校验身份authentication, 授权用户authorization
    * subject.login(oAuthToken);表示执行登录逻辑, 赋予shiroToken, 但没登录结果.
    * 执行登录逻辑, 则会调到realm对象上
    * */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        Subject subject = getSubject(servletRequest, servletResponse);
//        String token = request.getHeader(SystemConstant.HEADER_TOKEN);
//        OAuthToken oAuthToken = new OAuthToken(token);
//        subject.login(oAuthToken);

        /*
        这里执行login, 可以看源码. 最终会执行loginSuccess or loginFailure
         */
        boolean executeLogin = executeLogin(servletRequest, servletResponse);
        return executeLogin;
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return super.onLoginSuccess(token, subject, request, response);
    }

    /*
    * 这里抛异常好像没屌用, exceptionAdvice捕获不了这里的异常.
    * 只能通过篡改response来返回
    * */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json;charset=utf-8");
        try {
            CallResult result = CallResult.returnCode(HLReturnCode.BASE_TOKEN_UNAUTHORIZED);
            String json = JSON.toJSONString(result);
            response.getWriter().print(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /*
    * shiro框架所属的token对象, authenticationToken, 也就是身份校验的token
    * */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String token = request.getHeader(SystemConstant.HEADER_TOKEN);
        return new OAuthToken(token);
    }


}
