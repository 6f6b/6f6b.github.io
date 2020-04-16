package com.example.accessdatajpa;

import com.example.accessdatajpa.model.Customer;
import com.example.accessdatajpa.service.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessDataJpaApplication {
    private static Logger log = LoggerFactory.getLogger(AccessDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return args -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()){
                log.info(customer.toString());
            }
            log.info("");
            // fetch customer by id
            log.info("Customers found with id:");
            log.info("-------------------------------");
            Customer customer = repository.findById(1L).get();
            log.info(customer.toString());
        };
    }
}
