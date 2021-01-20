package com.example.quartzdemo;

import org.springframework.stereotype.Component;

/**
 * @Author LiuFeng
 * @Date 2021/1/20
 */
@Component
public class Receiver {
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
