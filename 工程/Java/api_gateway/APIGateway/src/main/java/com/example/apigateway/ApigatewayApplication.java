package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(predicateSpec -> predicateSpec.path("/gateway/product").filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/home").addRequestHeader("ID","LiuFeng")).uri("http://localhost:8081"))
                .route(predicateSpec -> predicateSpec.path("/gateway/order").filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/home").addRequestHeader("ID","LiuFeng")).uri("http://localhost:8082"))
                .build();
    }
}

@RestController
class ServiceInstanceRestController {

    @RequestMapping("/home")
    public String home(){
        return "欢迎调用GATEWAY-SERVICE";
    }
}
