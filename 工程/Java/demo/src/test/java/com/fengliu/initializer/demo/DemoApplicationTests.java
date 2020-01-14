package com.fengliu.initializer.demo;

import com.fengliu.initializer.demo.proj.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class DemoApplicationTests {
    /**
     * 注入Spring容器
     */
    @Autowired
    private ApplicationContext context;
    @Autowired
    private  Employee employee;
    @Test
    void contextLoads() {
//        Employee employee = context.getBean(Employee.class);
        System.out.println(this.employee);
    }

}
