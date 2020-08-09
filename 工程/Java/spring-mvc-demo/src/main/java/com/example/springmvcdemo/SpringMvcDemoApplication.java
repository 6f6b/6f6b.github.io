package com.example.springmvcdemo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Pointcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringMvcDemoApplication {

    public static void main(String[] args) {
        Pointcut
        SpringApplication.run(SpringMvcDemoApplication.class, args);
    }

}
