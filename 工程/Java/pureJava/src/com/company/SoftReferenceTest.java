package com.company;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
    public static class Person{
        String name;
        int age;

        Person(String name,int age){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception{
        Person person = new Person("liufeng",16);
        WeakReference<Person> softReference = new WeakReference<>(person);
        person = null;
        System.gc();
        Thread.sleep(60*20*1000);
        System.out.println(softReference.get());
    }
}
