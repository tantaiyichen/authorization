package com.admin.config;

import com.admin.security.JwtAuthenticationFilter;
import com.admin.security.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * @Author: Caiqin
 * @Date: 2020/7/22 19:25
 * @Description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        //使用自定义身份验证
        auth.authenticationProvider( new JwtAuthenticationProvider( userDetailsService ) );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //由于使用的是jwt，禁用csrf
        http.cors().and().csrf().disable().authorizeRequests()
                //跨域预检请求
                .antMatchers( HttpMethod.OPTIONS, "/**" ).permitAll()
                //web jars
                .antMatchers( "/webjars/**" ).permitAll()
                //查看SQL监控
                .antMatchers( "/druid/**" ).permitAll()
                //首页和登录页面
                .antMatchers( "/" ).permitAll()
                .antMatchers( "/login" ).permitAll()
                //swagger
                .antMatchers( "/swagger-ui.html" ).permitAll()
                .antMatchers( "/swagger-resources/**" ).permitAll()
                .antMatchers( "/v2/api-docs" ).permitAll()
                .antMatchers( "/webjars/springfox-swagger-ui/**" ).permitAll()
                //验证码
                .antMatchers( "/captcha.jpg**" ).permitAll()
                //服务监控
                .antMatchers( "/actuator/**" ).permitAll()
                //其他所有请求需要身份认证
                .anyRequest().authenticated();
        //退出登录处理器
        http.logout().logoutSuccessHandler( new HttpStatusReturningLogoutSuccessHandler() );
        //token验证过滤器
        http.addFilterBefore( new JwtAuthenticationFilter( authenticationManager() ),
                UsernamePasswordAuthenticationFilter.class );
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

}
