package cn.hl.common.oauth;

import cn.hl.common.constant.SystemConstant;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class OAuthFilter extends AuthenticatingFilter {
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String token = request.getHeader(SystemConstant.HEADER_TOKEN);
        return new OAuthToken(token);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Subject subject = getSubject(servletRequest, servletResponse);
        String token = request.getHeader(SystemConstant.HEADER_TOKEN);
        OAuthToken oAuthToken = new OAuthToken(token);
        subject.login(oAuthToken);
        return true;
    }
}
