package cn.hl.common.config;

import cn.hl.common.oauth.OAuthFilter;
import cn.hl.common.oauth.OAuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;

@Configuration
public class OAuthConfig {

    @Bean("securityManager")
    public SecurityManager securityManager(OAuthRealm realm) {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(realm);
        return webSecurityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        HashMap<String, Filter> filterMap = new HashMap<>();
        filterMap.put("oauth", new OAuthFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        HashMap<String , String> pathMap = new HashMap<>();
        pathMap.put("/user/login", "anon");
        pathMap.put("/**", "oauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(pathMap);
        return shiroFilterFactoryBean;
    }
}
