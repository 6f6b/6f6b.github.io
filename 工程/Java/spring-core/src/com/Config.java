package com;

import com.listener.EmailListener;
import com.pulisher.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import java.beans.BeanProperty;

@Configuration
@ImportResource("/com/apps.xml")
public class Config {
    @Bean
//    @Profile("development")
    public CustomEnvironment customEnvironment(){
        System.out.println("nihao");
        return new CustomEnvironment("dev");
    }

    @Bean
    public EmailService emailService(){
        return new EmailService();
    }

    @Bean
    public EmailListener emailListener(){
        return new EmailListener();
    }
}
