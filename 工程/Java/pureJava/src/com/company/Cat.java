package com.company;

public class Cat extends Animal {
    public Cat(){
        System.out.println("this is a cat");
    }

    void sayHello(){
        System.out.println(this.name);
    }
}
