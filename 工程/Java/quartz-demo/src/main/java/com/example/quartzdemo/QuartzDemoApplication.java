package com.example.quartzdemo;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class QuartzDemoApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(QuartzDemoApplication.class, args);
    }

}
