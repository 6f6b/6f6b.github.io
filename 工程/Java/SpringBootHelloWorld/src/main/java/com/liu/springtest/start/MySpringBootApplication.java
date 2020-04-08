package com.liu.springtest.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().run()
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
