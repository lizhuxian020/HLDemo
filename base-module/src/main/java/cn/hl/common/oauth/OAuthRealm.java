package cn.hl.common.oauth;

import cn.hl.common.config.JwtConfig;
import cn.hl.common.model.exception.HLReturnCode;
import cn.hl.common.model.exception.HLRunTimeException;
import cn.hl.common.model.jwt.TokenMessage;
import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OAuthRealm extends AuthorizingRealm {

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public boolean supports(AuthenticationToken token) {
        if (token instanceof OAuthToken) {
            return true;
        }
        return super.supports(token);
    }

    /*
    * 授权
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /*
    * 身份校验
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        OAuthToken oAuthToken = (OAuthToken) authenticationToken;
        String tokenPrincipal = (String) oAuthToken.getPrincipal();
        try {
            Claims claimsByToken = jwtConfig.getClaimsByToken(tokenPrincipal);
            String tokenJsonString = claimsByToken.getSubject();
            TokenMessage tokenMessage = JSON.parseObject(tokenJsonString, TokenMessage.class);
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(tokenMessage, tokenPrincipal, getName());
            return simpleAuthenticationInfo;
        } catch (ExpiredJwtException expiredJwtException) {
//            e.printStackTrace();
            throw new HLRunTimeException(HLReturnCode.BASE_TOKEN_UNAUTHORIZED);
        }
    }
}
