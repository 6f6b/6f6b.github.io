package com.company;

import sun.misc.Unsafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class ThreadC {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t2.start();
                try {
                    t2.join();
                    Unsafe unsafe = Unsafe.getUnsafe();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

//        try {
//            t.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        System.out.println("hello");
    }
}
