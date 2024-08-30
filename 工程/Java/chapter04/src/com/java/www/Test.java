package com.java.www;

import cn.java.www.Pig;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = new Animal();

        System.out.println(dog.defaultName);
        System.out.println(dog.protectedName);
        System.out.println(dog.publicNmae);
    }
}
