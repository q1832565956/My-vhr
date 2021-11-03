package com.javaboy.vhr.config;

import com.javaboy.vhr.entity.Hr;
import com.javaboy.vhr.entity.Role;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public  class CustomDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {


        for (ConfigAttribute needRole : collection) {
            if ("ROLE_LOGIN".equals(needRole.getAttribute())){
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请先登录");
                }else{
                    return;
                }
            }
            Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
            for (GrantedAuthority role : roles) {
                String authority = role.getAuthority();
                if (needRole.getAttribute().equals(authority)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
