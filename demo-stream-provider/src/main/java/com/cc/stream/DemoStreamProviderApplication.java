package com.cc.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class DemoStreamProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamProviderApplication.class, args);
    }
}
