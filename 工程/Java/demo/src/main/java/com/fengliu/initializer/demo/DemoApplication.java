package com.fengliu.initializer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
/**
 * 通过@ImportResource加载指定文件
 */
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
