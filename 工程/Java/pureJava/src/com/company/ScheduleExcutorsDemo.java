package com.company;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuFeng
 */
public class ScheduleExcutorsDemo {
    public static Logger logger = new Logger();

    public static class Task implements Runnable{
        private String message;

        public Task(String message){
            this.message = message;
        }
        @Override
        public void run() {
            try {
                logger.info(String.format("%s-开始睡3秒",this.message));
                Thread.sleep(5000);
                logger.info(String.format("%s-睡完了",this.message));
            }catch (InterruptedException e){
                logger.info("interruption");
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task("1");


        ExecutorService service = Executors.newSingleThreadExecutor();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.submit(task);
                logger.info("over");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                }catch (InterruptedException e){
                }
                service.shutdown();
            }
        }).start();
//        new Thread(task).start();

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.submit(task);
        //scheduledExecutorService.schedule(task,5,TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleWithFixedDelay(task,5,2,TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(task,5,2,TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(new Task("2"),1,1,TimeUnit.SECONDS);
    }

    public static class Logger{
        private PrintStream printStream = System.out;
        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss------");
        public void info(String message){
            Date now = new Date();
            printStream.println(dateFormat.format(now)+message);
        }
    }
}
