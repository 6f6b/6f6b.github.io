package com.example.authenticatingldap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping("/")
    public String home(){
        return "Welcome to my home page";
    }
}
