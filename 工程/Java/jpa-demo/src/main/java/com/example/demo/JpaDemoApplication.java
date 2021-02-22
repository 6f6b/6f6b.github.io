package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JpaDemoApplication.class, args);
        Dog dog = new Dog();
        dog.name = "白狗子";
        DogHandler dogHandler = new DogHandler();
        dogHandler.handle(dog);
    }

}
