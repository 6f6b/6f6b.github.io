package com.example.springmvcdemo;

import com.example.springmvcdemo.config.Swagger;
import com.example.springmvcdemo.dao.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.data.repository.Repository;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.persistence.Entity;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringMvcDemoApplication {

    public static void main(String[] args) throws JsonProcessingException {
        HttpServlet servlet;
        ServletContext context2;
        ApplicationContext context;
        org.apache.catalina.core.ApplicationContext context1;
        DispatcherServlet servlet1;
        HttpRequestHandler handler;
        ServletContext context3;
        WebApplicationInitializer initializer;
        SpringServletContainerInitializer initializer1;
        SpringApplication application = new SpringApplication(SpringMvcDemoApplication.class);
        application.addListeners();
        application.run(args);

        /*Jackson 的使用*/
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        Person person = new Person("liufeng",26);

        List<String> houses = new ArrayList<>();
        houses.add("英俊二期");
        person.houses = houses;

        List<Person> sons = new ArrayList<>();
        Person child = new Person("刘乐山",1);
        sons.add(child);
        person.sons = sons;

        Map<String,String> map = new HashMap<>();
        map.put("老婆","zhaorui");
        person.map = map;

        String json = "";
        try {
            json = objectMapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //System.out.println(json);
        //Person person1 = objectMapper.readValue(json,Person.class);
        //System.out.println(person1.toString());
    }
}
