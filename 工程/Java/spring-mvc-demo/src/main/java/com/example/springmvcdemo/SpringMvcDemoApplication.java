package com.example.springmvcdemo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

@SpringBootApplication
public class SpringMvcDemoApplication {

    public static void main(String[] args) {
        HttpServlet servlet;
        ServletContext context2;
        ApplicationContext context;
        org.apache.catalina.core.ApplicationContext context1;
        DispatcherServlet servlet1;
        HttpRequestHandler handler;
        ServletContext context3;
        WebApplicationInitializer initializer;
        SpringServletContainerInitializer initializer1;
        SpringApplication.run(SpringMvcDemoApplication.class, args);
    }
}
