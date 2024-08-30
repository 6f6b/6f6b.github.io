package com.example.mybatisdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.mybatisdemo.mapper.UserMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDataSouceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

//    @Bean
//    public UserMapper userMapper(){
//
//    }
}
