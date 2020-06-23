package com.cc.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/8/30 15:59
 * Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket restApi(@Value("${spring.application.name}") String appName) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(appName))
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cc.provider.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(String appName) {
        return new ApiInfoBuilder().title("api 文档")
                .description("api 文档,rootPath=/"+appName)
                .version("1.0")
                .build();
    }
}
