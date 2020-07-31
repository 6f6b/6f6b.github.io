package com;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

public class Person {
    public List<Dog> dogs;

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
