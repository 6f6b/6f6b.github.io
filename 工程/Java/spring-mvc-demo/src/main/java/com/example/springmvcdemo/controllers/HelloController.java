package com.example.springmvcdemo.controllers;

import com.example.springmvcdemo.aop.aspect.WebLog;
import com.example.springmvcdemo.del.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContext;
import java.util.Map;

@RestController
@RequestMapping("hello/")
@ConfigurationProperties(prefix = "hello")
public class HelloController {
    String name;
    Integer age;
    Map<String,String> map;

    @Autowired
    private AcmeProperties acmeProperties;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @GetMapping("/")
    public String home() {
        int[] arr = {1};
        int a = arr[1];
        return "hello";
    }

    @GetMapping("/hello")
    @WebLog
    public String handle(Object ojc){
        return name + age.toString() + "岁";
    }


//
//    @InitBinder
//    protected  void initBinder(WebDataBinder binder){
//        System.out.println(binder.toString());
//    }

    @ExceptionHandler
    @ResponseBody
    public String handle(Exception ex) {
        //ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.ACCEPTED);
        return ex.toString()+"Controller 内的exceptionhandler";
    }
}
