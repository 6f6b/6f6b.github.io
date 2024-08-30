package com.company.io;

import java.io.Serializable;

/**
 * @author LiuFeng
 */
public class Person implements Serializable {
    String name;
    Dog dog;

    public void sayHello(){
        System.out.println("hello IM"+this.name);
    }
}
