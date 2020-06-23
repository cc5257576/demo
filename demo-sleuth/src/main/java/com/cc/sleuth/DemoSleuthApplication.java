package com.cc.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class DemoSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSleuthApplication.class, args);
    }

}
