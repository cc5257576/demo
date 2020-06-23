package com.cc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/10/11 14:22
 * Description:
 */
//@Configuration
public class BeanConfig {

    @Bean
    public static PasswordEncoder getPasswordEncoder( ){
        DelegatingPasswordEncoder delegatingPasswordEncoder =
                (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //设置defaultPasswordEncoderForMatches为NoOpPasswordEncoder
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
        return delegatingPasswordEncoder;
    }
}
