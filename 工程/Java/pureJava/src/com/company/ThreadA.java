package com.company;

import java.io.PrintStream;

/**
 * @author LiuFeng
 */
public class ThreadA implements Runnable {
    private PrintStream pr = System.out;
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                pr.println(Thread.currentThread().getName());
                Thread.sleep(2000);
            }catch (InterruptedException e){
                pr.println(e.toString());
            }
        }
    }
}
