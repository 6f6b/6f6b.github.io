package com.example.quartzdemo.common;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Author LiuFeng
 * @Date 2021/1/27
 */
public class ExecutorInstanceHelper {

    /**
     * 当前cpu数
     */
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    /**
     * 线程空闲后的存活时长
     */
    private static final int KEEP_ALIVE_TIME = 30;
    /**
     * 队列最大值
     */
    private static final int QUEUE_CAPACITY_SIZE = 1000;

    private ExecutorInstanceHelper() {
    }

    private static Executor cpuExecutor;
    private static Executor resourceExecutor;

    /**
     * 获取计算密集型线程池
     * @return executor
     */
    public static Executor getCpuExecutor() {
        if(cpuExecutor == null) {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            // 配置核心线程数
            executor.setCorePoolSize(CPU_COUNT);
            // 配置最大线程数
            executor.setMaxPoolSize(CPU_COUNT * 2 + 1);
            // 配置队列大小
            executor.setQueueCapacity(QUEUE_CAPACITY_SIZE);
            // 配置空闲线程存活时间
            executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
            // 配置线程池中的线程的名称前缀
            executor.setThreadNamePrefix("async-CPU-");
            //执行初始化
            executor.initialize();
            cpuExecutor = executor;
        }

        return cpuExecutor;
    }

    /**
     * 获取资源密集型线程池
     * @return executor
     */
    public static Executor getResourceExecutor() {
        if(resourceExecutor == null) {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            // 配置核心线程数
            executor.setCorePoolSize(CPU_COUNT * 2);
            // 配置最大线程数
            executor.setMaxPoolSize(CPU_COUNT * 2 + 1);
            // 配置队列大小
            executor.setQueueCapacity(QUEUE_CAPACITY_SIZE);
            // 配置空闲线程存活时间
            executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
            // 配置线程池中的线程的名称前缀
            executor.setThreadNamePrefix("async-IO-");
            //执行初始化
            executor.initialize();
            resourceExecutor = executor;
        }

        // 使用TTL包装线程池,使其具备传递上线文传递threadLocal的功能
        return resourceExecutor;
    }
}
