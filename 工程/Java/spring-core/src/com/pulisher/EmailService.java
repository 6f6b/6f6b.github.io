package com.pulisher;

import com.event.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

public class EmailService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    private List<String> blackList;

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher var1){
        this.publisher = var1;
    }

    public void sendEmail(String address,String content){
        if (this.blackList != null && this.blackList.contains(address)){
            publisher.publishEvent(new CustomEvent(this,address,content));
            System.out.println("send faild(in black list)："+address);
            return;
        }
        System.out.println("send success："+address);
    }
}
