package cn.hl.common.oauth;

import org.apache.shiro.authc.AuthenticationToken;

public class OAuthToken implements AuthenticationToken {

    private String token;

    public OAuthToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
