package com.example.quartzdemo.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public SchedulerFactory schedulerFactory(){
        SchedulerFactory sf = new StdSchedulerFactory();
        return sf;
    }

    @Bean
    public Scheduler scheduler(SchedulerFactory schedulerFactory) throws Exception{
        return schedulerFactory.getScheduler();
    }
}
