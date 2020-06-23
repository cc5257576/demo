package com.cc.consumer.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/25 18:55
 * Description:
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("demo", "123456");
    }
}
