package com.example.springmvcdemo.controllers;

import com.example.springmvcdemo.aop.aspect.WebLog;
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

@RestController
@RequestMapping("hello/")
public class HelloController {

    @GetMapping("/")
    public String home() {
        int[] arr = {1};
        int a = arr[1];
        return "hello";
    }

    @GetMapping("/hello")
    @WebLog
    public String handle(Object ojc){
        return ojc.toString();
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
