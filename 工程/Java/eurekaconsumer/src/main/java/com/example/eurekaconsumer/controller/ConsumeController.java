package com.example.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consume")
    public String consume(){
        return restTemplate.getForObject("http://eurekaclient01/hello", String.class);
    }
}
