package com.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: Caiqin
 * @Date: 2020/7/22 21:07
 * @Description: 权限封装
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority){
        this.authority=authority;
    }

    public void setAuthority(String authority){
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
