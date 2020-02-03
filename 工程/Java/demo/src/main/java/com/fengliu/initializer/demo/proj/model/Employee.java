package com.fengliu.initializer.demo.proj.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;

/**
 * 将Employee所对应的对象添加为Spring容器的组件
 */
@Component

/**
 * 指定从哪个外部配置文件中加载配置
 */
@PropertySource(value = "classpath:employee.properties")

/**
 * 如果需要使用@ConfigurationProperties注解，那么前提是，当对象必须是Spring容器的组件
 * @ConfigurationProperties：将配置文件中的配置属性与对象中的属性进行关联(在默认配置文件中去加载)
 * prefix：指定配置文件中的哪个配置进行关联（指定下一级怎么指定？）
 */
@ConfigurationProperties(prefix = "employee01")

//@Validated  //开启数据校验功能
public class Employee {
    /**
     * @Value("字面量、${配置文件中的属性值or系统变量中的属性值}、#{spEL表达式}")
     */
//    @Value("${employee01.username}")
//    @Email  //通过这个注解要求username这个属性的值必须是email格式的
    private String username;
    //    @Value("#{10+20}")
//    @NotEmpty   //通过这个注解要求age这个属性的值必须不能为空
    private Integer age;
    private String[] subjects;
    private Dept dept;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                "username='" + username + '\'' +
                ", age=" + age +
                ", subjects=" + Arrays.toString(subjects) +
                ", dept=" + dept +
                '}';
    }
}
