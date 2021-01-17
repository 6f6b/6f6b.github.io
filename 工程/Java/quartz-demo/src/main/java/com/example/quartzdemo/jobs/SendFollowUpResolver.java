package com.example.quartzdemo.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendFollowUpResolver implements JobResolver{
    private Logger logger = LoggerFactory.getLogger(SendFollowUpResolver.class);
    @Override
    public void excute(String jobContent) {
        logger.info(jobContent);
    }
}
