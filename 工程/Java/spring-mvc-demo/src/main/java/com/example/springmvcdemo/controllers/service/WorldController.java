package com.example.springmvcdemo.controllers.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/world")

public class WorldController {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello world";
    }
}
