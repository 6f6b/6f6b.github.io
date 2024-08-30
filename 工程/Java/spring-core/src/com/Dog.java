package com;

public class Dog {
    public String name;

    public Dog(){
        System.out.println("Dog initiated");
    }

    public void setName(String name) {
        System.out.println("set dog name");
        this.name = name;
    }
}
