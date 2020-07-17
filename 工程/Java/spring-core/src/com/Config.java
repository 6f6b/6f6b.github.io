package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ImportResource("/com/apps.xml")
public class Config {
//    @Bean
//    @Profile("development")
//    public CustomEnvironment customEnvironment(){
//        System.out.println("nihao");
//        return new CustomEnvironment("dev");
//    }
}
