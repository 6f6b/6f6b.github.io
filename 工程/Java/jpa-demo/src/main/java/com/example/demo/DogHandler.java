package com.example.demo;

/**
 * @author LiuFeng
 */
public class DogHandler extends AnimalHandler<Dog> {

    @Override
    public void kill(Dog dog) {
        System.out.println("kill "+dog.name);
    }
}
