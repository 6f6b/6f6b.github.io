package com.liu.springtest.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.scheduling.annotation.EnableScheduling;
=======
import org.springframework.boot.builder.SpringApplicationBuilder;
>>>>>>> e48c88ba46a688a52a0012165358d09be48a8286

@SpringBootApplication
@EnableScheduling

public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
