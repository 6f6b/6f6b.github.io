package com.example.beian.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/health")
    public String health(){
        logger.info("访问了健康接口");
        return "working !";
    }
}
