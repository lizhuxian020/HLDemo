package cn.hl.common.oauth;

import cn.hl.common.constant.SystemConstant;
import cn.hutool.http.server.HttpServerRequest;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OAuthFilter extends AuthenticatingFilter {
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServerRequest request = (HttpServerRequest)servletRequest;
        String token = request.getHeader(SystemConstant.HEADER_TOKEN);
        return new OAuthToken(token);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
