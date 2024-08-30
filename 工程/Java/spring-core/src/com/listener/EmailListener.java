package com.listener;

import com.event.CustomEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

public class EmailListener {

    @EventListener(condition = "#customEvent.content == 'hello'")
    @Order(2)
    public void listen1(CustomEvent customEvent){
        System.out.println("received event1:\n"+customEvent.toString());

    }

    @EventListener
    @Order(1)
    public void listen2(CustomEvent customEvent){
        System.out.println("received event2:\n"+customEvent.toString());

    }
}
