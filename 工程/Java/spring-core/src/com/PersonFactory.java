package com;

public class PersonFactory {
    public static Person createPerson(){
        Person person = new Person();
        person.name = "张学友";
        return person;
    }
}
