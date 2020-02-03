package com.fengliu.initializer.demo.proj.controller;

import com.fengliu.initializer.demo.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        System.out.println(this.service);
        return "Hello my name is liufeng";
    }
}
