package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LiuFeng
 */
public class ThreadLocalDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return atomicInteger.incrementAndGet();
        }
    };

    public static void main(String[] args) {

        AtomicReference
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 2; i++) {
                                System.out.println(threadId.get());
                            }
                        }
                    }).start();
                }
            }
        }).start();
    }


}
