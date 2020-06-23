package com.cc.zuul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class DemoZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoZuulApplication.class, args);
    }

}
