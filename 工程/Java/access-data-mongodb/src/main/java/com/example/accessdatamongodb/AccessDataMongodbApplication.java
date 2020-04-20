package com.example.accessdatamongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@EnableMongoRepositories
public class AccessDataMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessDataMongodbApplication.class, args);
    }

}
