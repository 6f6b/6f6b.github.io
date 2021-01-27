package com.example.quartzdemo.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Random;

@Component
public class SendFollowUpResolver implements JobResolver{
    private Logger logger = LoggerFactory.getLogger(SendFollowUpResolver.class);
    @Override
    public void excute(Long id) {
        Random random = new Random();
        int sleepSecond = random.nextInt(5);
        try {
            Thread.sleep(sleepSecond*1000);
            logger.info(Thread.currentThread().getName()+"----->"+id.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
