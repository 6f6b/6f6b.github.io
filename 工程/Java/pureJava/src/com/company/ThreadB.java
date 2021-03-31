package com.company;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author LiuFeng
 */
public class ThreadB implements Runnable {
    private PrintStream pr = System.out;

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                if (i == 2){
                    Thread a = new Thread(new ThreadA(),"A");
                    a.start();
                    a.join();
                }

                pr.println(Thread.currentThread().getName());
                Thread.sleep(2000);
            }catch (InterruptedException e){
                pr.println(e.toString());
            }
        }
    }

    static class CallableTask implements Callable<String>{
        private String title;

        public CallableTask(String title){
            this.title = title;
        }
        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(3000);
                System.out.println(String.format("执行-----------%s",this.title));
            }catch (InterruptedException e){
                System.out.println(String.format("%s被打断",title));
            }
            return "结果-"+title;
        }
    }

    static class Task implements Runnable{

        private String title;
        public Task(String title){
            this.title = title;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println(String.format("执行-----------%s",this.title));
            }catch (InterruptedException e){
                System.out.println(String.format("%s被打断",title));
            }finally {
//                try {
//                    Thread.sleep(5000);
//                    System.out.println(String.format("%s 打断后继续睡",title));
//                }catch (InterruptedException e){}
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<CallableTask> callableTasks = new ArrayList<>();
                for (int i=0;i<10;i++){
                    try {
                        Thread.sleep(10);
                        CallableTask task = new CallableTask(String.format("任务-%d",i));
                        callableTasks.add(task);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println("开始invoke all - "+new Date());
                    List<Future<String>> futures = executorService.invokeAll(callableTasks);
                    System.out.println("开始invoke success - "+new Date());
//                    for (Future future: futures) {
//                        try {
//                            System.out.println("开始获取"+new Date());
//                            System.out.println(future.get());
//                            System.out.println("获取成功"+new Date());
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("获取结束"+new Date());
                }catch (Exception e){
                    System.out.println("被打断------------------------------");
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<1000;i++){
//                    try {
//                        Thread.sleep(500);
//                        Task task = new Task(String.format("任务-%d",i));
//                        try {
//                            Future future = executorService.submit(task);
//                            System.out.println(String.format("提交任务--%d",i));
//                        }catch (RejectedExecutionException e){
//                            System.out.println("已经shutdown 拒绝新的任务提交");
//                            break;
//                        }
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<100;i++) {
//                    try {
//                        Thread.sleep(1000);
//                    }catch (InterruptedException e){
//                        System.out.println("睡眠的时候被打断");
//                    }
//                    if (i == 5){
//                        System.out.println("shut down");
//                        executorService.shutdown();
//                        int waitSecond = 3;
//                        try {
//                            if (!executorService.awaitTermination(waitSecond, TimeUnit.SECONDS)){
//                                System.out.println(String.format("%d秒内关机失败，将进行强制关机",waitSecond));
//                                List<Runnable> runnables = executorService.shutdownNow();
//                                System.out.println(String.format("等待执行的任务数-%d",runnables.size()));
//                                if (!executorService.awaitTermination(waitSecond, TimeUnit.SECONDS)){
//                                    System.out.println(String.format("%d秒内强制关机失败",waitSecond));
//                                }else {
//                                    System.out.println(String.format("%d秒内强制关机成功",waitSecond));
//                                }
//                            }else {
//                                System.out.println(String.format("成功在%d秒内关机",waitSecond));
//                            }
//                        }catch (InterruptedException e){
//                            System.out.println("等待关机的时候被打断");
//                        }
//                        break;
//                    }
//                }
//            }
//        }).start();
    }
}
