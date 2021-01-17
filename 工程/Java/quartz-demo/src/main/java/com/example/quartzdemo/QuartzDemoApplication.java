package com.example.quartzdemo;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
@SpringBootApplication
public class QuartzDemoApplication {
    public static ApplicationContext applicationContext;

    public static void main(String[] args) throws Exception{
        applicationContext = SpringApplication.run(QuartzDemoApplication.class, args);
    }

}
