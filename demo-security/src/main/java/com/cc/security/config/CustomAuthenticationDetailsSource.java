package com.cc.security.config;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/10/16 15:41
 * Description:
 */
@Component("authenticationDetailsSource")
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
        return new CustomWebAuthenticationDetails(request);
    }
}
