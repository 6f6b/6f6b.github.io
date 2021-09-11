package com.example.eurekaclient02.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String sayHello(HttpServletRequest request){
        System.out.println("请求了hello");
        String result = requestWith(request,"eureka-client-3","/hello").getBody();
        return "hello im liufeng , from client 01\n"+result;
    }

    private ResponseEntity<String> requestWith(HttpServletRequest preRequest, String serviceId, String path){
        String runningModelName = "RUNNING-MODEL";
        String runningModelDebugValue = "DEBUG";
        String clientAddressName = "CLIENT-ADDRESS";
        HttpHeaders headers = new HttpHeaders();
        if (runningModelDebugValue.equals(preRequest.getHeader(runningModelName))) {
            headers.add(runningModelName,runningModelDebugValue);
            String clientAddressValue = preRequest.getHeader(clientAddressName);
            headers.add(clientAddressName,(clientAddressValue == null) ? preRequest.getRemoteAddr() : clientAddressValue);
        }

        ServiceInstance instance = getInstanceWith(preRequest,serviceId);
        HttpEntity<MultiValueMap<String,Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(null,headers);
        return restTemplate.exchange(uriWith(instance,path), HttpMethod.GET,entity,String.class);
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
            String clientAddressName = "CLIENT-ADDRESS";
            String clientAddress = request.getHeader(clientAddressName);
            if (clientAddress == null){
                clientAddress = request.getRemoteAddr();
            }
            String finalClientAddress = clientAddress;
            Optional<ServiceInstance> optionalServiceInstance = instances.stream().filter((ins)->{return ins.getHost().equals(finalClientAddress);}).findFirst();
            if (optionalServiceInstance.isPresent()){
                instance = optionalServiceInstance.get();
            }
        }
        return instance;
    }
}
