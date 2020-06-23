package com.cc.zuul.config;

import com.cc.zuul.filter.AuthorizedFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/4 9:59
 * Description:
 */
//@Configuration
public class ZuulConfig {

    @Value("${excludeUrlPaths}")
    public String[] excludeUrlPaths;

    @Bean
    public AuthorizedFilter getAuthorizedFilter(){
        return new AuthorizedFilter(excludeUrlPaths);
    }
}
