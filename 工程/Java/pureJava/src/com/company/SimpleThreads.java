package com.company;

import java.util.concurrent.FutureTask;

/**
 * @author LiuFeng
 */
public class SimpleThreads {
//    volatile
//    public
    // Display a message, preceded by
    // the name of the current thread
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    private static class MessageLoop
            implements Runnable {
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    Thread t = new Thread(new SleepT());
                    t.start();
                    t.join();
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    private static class SleepT implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                threadMessage("SleepT 被打断");
            }
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        Object o = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t1开始休息6秒");
                    Thread.sleep(8000);
//                    System.out.println("notify");
//                    synchronized (this){
//                        notifyAll();
//                    }
//                    System.out.println("休息4秒");
//                    Thread.sleep(4000);
                    System.out.println("t1结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (t){
                        System.out.println("t2取锁成功");
                        t.wait();
                        System.out.println("t2取锁结束");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2结束");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (t){
                        System.out.println("t3取锁成功");
                        t.wait();
                        System.out.println("t3取锁结束");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3结束");
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t4开始休息2秒");
                    Thread.sleep(2000);
                    System.out.println("notify");
                    synchronized (t){
                        t.notifyAll();
                        System.out.println("通知了先休息2秒");
                        Thread.sleep(2000);
                        System.out.println("休息结束");
                    }
                    System.out.println("休息4秒");
                    Thread.sleep(4000);
                    System.out.println("t4结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t2.start();
        t3.start();
        t4.start();

        t.interrupt();
        //
//        // Delay, in milliseconds before
//        // we interrupt MessageLoop
//        // thread (default one hour).
//        long patience = 1000 * 3;
//
//        // If command line argument
//        // present, gives patience
//        // in seconds.
//        if (args.length > 0) {
//            try {
//                patience = Long.parseLong(args[0]) * 1000;
//            } catch (NumberFormatException e) {
//                System.err.println("Argument must be an integer.");
//                System.exit(1);
//            }
//        }
//
//        threadMessage("Starting MessageLoop thread");
//        long startTime = System.currentTimeMillis();
//        Thread t = new Thread(new MessageLoop());
//        t.start();
//
//        threadMessage("Waiting for MessageLoop thread to finish");
//        // loop until MessageLoop
//        // thread exits
//        while (t.isAlive()) {
//            threadMessage("Still waiting...");
//            // Wait maximum of 1 second
//            // for MessageLoop thread
//            // to finish.
//            if (((System.currentTimeMillis() - startTime) > patience)
//                    && t.isAlive()) {
//                threadMessage("Tired of waiting!");
//                t.interrupt();
//                // Shouldn't be long now
//                // -- wait indefinitely
//                t.join();
//            }
//        }
//        threadMessage("Finally!");
    }
}