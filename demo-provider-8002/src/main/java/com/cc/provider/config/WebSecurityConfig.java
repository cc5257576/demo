package com.cc.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/31 15:21
 * Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/css/**", "/index").permitAll()     /*与之匹配的请求/CSS/*和/索引完全无障碍*/
//                .antMatchers("/user/**").hasRole("USER")        /*与之匹配的请求/用户/*要求对用户进行身份验证，并且必须与用户角色*/
//                .and().formLogin()
//                .loginPage("/login").failureUrl("/login-error");                /*基于表单的身份验证是通过自定义登录页和故障url启用的。*/
//        http.httpBasic().disable();

        // 表示所有的访问都必须进行认证处理后才可以正常进行
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
        // 所有的Rest服务一定要设置为无状态，以提升操作性能
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //要先设置密码的加密方式, 把密码加密后的值设置进去
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("demo")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }


}
