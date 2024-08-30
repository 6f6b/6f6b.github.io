package com.example.springmvcdemo.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liufeng
 * @created
 */

@Configuration
@EnableSwagger2
public class Swagger {
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springmvcdemo.controllers"))
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("spring-mvc-demo api document")
                .description("用restful风格写的接口")
                .version("1.0")
                .license("maked by liufeng")
                .build();
    }
}
