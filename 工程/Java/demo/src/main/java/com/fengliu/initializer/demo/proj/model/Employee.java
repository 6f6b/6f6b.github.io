package com.fengliu.initializer.demo.proj.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 如果需要使用@ConfigurationProperties注解，那么前提是，当对象必须是Spring容器的组件
 * @ConfigurationProperties：将配置文件中的配置属性与对象中的属性进行关联
 * prefix：指定配置文件中的哪个配置进行关联（指定下一级怎么指定？）
 */
@ConfigurationProperties(prefix = "employee01")

/**
 * 将Employee所对应的对象添加为Spring容器的组件
 */
@Component
public class Employee {
    private String name;
    private Integer age;
    private String[] subjects;
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subjects=" + Arrays.toString(subjects) +
                ", dept=" + dept +
                '}';
    }
}
