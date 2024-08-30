package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.client.EurekaClient01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EurekaClient01 eurekaClient01;

    @RequestMapping("/consume")
    public String consume(){
        return restTemplate.getForObject("http://eurekaclient01/hello", String.class);
    }

    @RequestMapping("/consume/feign")
    public String consumeFeign(){
        return eurekaClient01.getResponse();
    }
}
