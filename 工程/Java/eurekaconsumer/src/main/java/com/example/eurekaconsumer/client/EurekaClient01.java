package com.example.eurekaconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eurekaclient01",path = "/private")
public interface EurekaClient01 {
    @RequestMapping("/hello")
    String getResponse();
}
