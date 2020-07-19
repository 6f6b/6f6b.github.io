package com.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
    private final String address;
    public final String content;

    public  CustomEvent(Object source,String address,String content){
        super(source);
        this.address = address;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CustomEvent{" +
                "address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
