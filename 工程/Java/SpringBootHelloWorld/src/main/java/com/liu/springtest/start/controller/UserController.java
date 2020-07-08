package com.liu.springtest.start.controller;

import com.liu.springtest.start.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private MyService services;

    @RequestMapping("sayHello")
    @ResponseBody
    @Bean
    public String sayHello() {
        System.out.println("service====" + this.services);
        return "Hello world";
    }
}
