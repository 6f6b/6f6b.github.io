package com.example.eurekaclient02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String sayHello(HttpServletRequest request){
        System.out.println("请求了hello");
        return "hello im liufeng , from client 03\n";
    }

    private String uriWith(ServiceInstance instance,String path){
        String uri = String.format("http://%s:%d%s",instance.getHost(),instance.getPort(),path);
        return uri;
    }

    private ServiceInstance getInstanceWith(HttpServletRequest request,String serviceId){
        //Header中是否有DEBUG标识
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        ServiceInstance instance = instances.stream().findAny().get();
        if ("DEBUG".equals(request.getHeader("RUNNING-MODEL"))){
            ServiceInstance temIns = instances.stream().filter((ins)->{return ins.getHost().equals(request.getRemoteAddr());}).findFirst().get();
            instance = (temIns == null) ? instance : temIns;
        }
        return instance;
    }
}
