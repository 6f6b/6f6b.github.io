package com.example.demo;

/**
 * @author LiuFeng
 */
public class AnimalHandler<P extends BaseAnimal> {
    public void handle(P p){
        BaseAnimal animal = new BaseAnimal();
        kill((P) animal);
    }

    public void kill(P p){
        System.out.println("hello");
    }
}
