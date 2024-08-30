package com.liufeng.thymeleaf.mode;

import java.util.Date;

public class User {
    private String name;
    private Integer age;
    private String address;
    private Date birthday;
    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = new Date();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthday() {
        return birthday;
    }
}
