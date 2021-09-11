package com.example.eurekaclient02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Eurekaclient02Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaclient02Application.class, args);
    }

}
