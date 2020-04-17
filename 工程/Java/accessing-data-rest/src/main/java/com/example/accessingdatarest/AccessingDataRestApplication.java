package com.example.accessingdatarest;

import com.example.accessingdatarest.model.Person;
import com.example.accessingdatarest.service.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataRestApplication {
    private static Logger log = LoggerFactory.getLogger(AccessingDataRestApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(AccessingDataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(PersonRepository repository){
        return args -> {
            repository.save(new Person("liu1","feng"));
            repository.save(new Person("liu2","feng"));
            repository.save(new Person("liu3","feng"));
            repository.save(new Person("liu4","feng"));
        };
    }
}
