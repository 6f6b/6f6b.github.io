package com.company.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

/**
 * @author LiuFeng
 */
public class ObjectStreamDemo {
    public static void main(String[] args) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/feng/gits/JAVAWeb/工程/Java/pureJava/src/com/company/io/object_out.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            Dog dog = new Dog();
            dog.name = "白狗子";
            Person person = new Person();
            person.dog = dog;
            person.name = "刘丰";
            objectOutputStream.writeObject(person);

            FileInputStream fileInputStream = new FileInputStream("/Users/feng/gits/JAVAWeb/工程/Java/pureJava/src/com/company/io/object_out.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Person readPerson = (Person) objectInputStream.readObject();
            readPerson.sayHello();
            System.out.println(readPerson.dog.name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
