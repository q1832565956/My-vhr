package com.javaboy.vhr.config;

import com.javaboy.vhr.entity.Menu;
import com.javaboy.vhr.entity.Role;
import com.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 *
 * 根据用户的请求url，查询该路径能被那几个角色所访问
 */

@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String url = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menus = menuService.getRoles();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(),url)) {
                List<Role> roles = menu.getRoles();
                String[] sRoles = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    sRoles[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(sRoles);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
