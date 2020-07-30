package com.admin.security;

import com.admin.util.SecurityUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Caiqin
 * @Date: 2020/7/23 18:51
 * @Description: 登录认证过滤器
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter{

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super( authenticationManager );
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取token并检查登录状态
        SecurityUtils.checkAuthentication( request );
        chain.doFilter( request,response );
    }
}
