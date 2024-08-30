package com;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

public class Person {
    public String name;
    public Dog dog;

    public Person(){
        System.out.println("Person initiated");
    }



    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setName(String name) {
        System.out.println("set person name");
        this.name = name;
    }
}
