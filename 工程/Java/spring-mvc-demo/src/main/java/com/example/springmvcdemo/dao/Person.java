package com.example.springmvcdemo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    public String name;
    @JsonIgnore
    public int age;
    public List<String> houses;
    public List<Person> sons;
    public Map<String,String> map;
    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
