package com.company;

import java.util.concurrent.*;

/**
 * @author LiuFeng
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool;
        ForkJoinTask<String> forkJoinTask = new ForkJoinTask<String>() {
            @Override
            public String getRawResult() {
                return null;
            }

            @Override
            protected void setRawResult(String value) {

            }

            @Override
            protected boolean exec() {
                return false;
            }
        };
        RecursiveAction recursiveAction;
        RecursiveTask<String> recursiveTask;
        //forkJoinPool.invoke(forkJoinTask);
        //ScheduledExecutorService scheduledExecutorService;
    }
}
