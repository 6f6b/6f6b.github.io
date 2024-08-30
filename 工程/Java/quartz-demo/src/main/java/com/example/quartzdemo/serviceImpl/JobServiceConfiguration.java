package com.example.quartzdemo.serviceImpl;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.net.InetAddress;
import java.util.concurrent.Executor;

/**
 * @Author LiuFeng
 * @Date 2021/1/22
 */
//@Configuration
public class JobServiceConfiguration {
    /**
     * 监听队列
     *
     * @return
     */
    @Bean
    public Queue addJobQueue(Environment environment) {
        return new Queue("rplus.service.app.doctor:job.add:queue",true,false,true);
    }
    @Bean
    public Queue updateJobQueue(Environment environment) { return new Queue("rplus.service.app.doctor:job.update:queue-"+environment.getProperty("server.port")); }

    /**
     * 交换机
     *
     * @return
     */
    @Bean
    public TopicExchange jobExchange() {
        return new TopicExchange("rplus.service.app.doctor:job:exchange");
    }

    /**
     * 绑定路由
     *
     * @return
     */
    @Bean
    public Binding bindingAddJobQueue(Queue addJobQueue, TopicExchange jobExchange) {
        return BindingBuilder.bind(addJobQueue).to(jobExchange).with("rplus.service.app.doctor:job:add");
    }
    @Bean
    public Binding bindingUpdateJobQueue(Queue updateJobQueue, TopicExchange jobExchange) {
        return BindingBuilder.bind(updateJobQueue).to(jobExchange).with("rplus.service.app.doctor:job:update");
    }

//    @Bean
//    public Executor executor(){
//
//        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
//        Visi
//        // 配置核心线程数
//        executor.setCorePoolSize(CPU_COUNT * 2);
//        // 配置最大线程数
//        executor.setMaxPoolSize(CPU_COUNT * 2 + 1);
//        // 配置队列大小
//        executor.setQueueCapacity(QUEUE_CAPACITY_SIZE);
//        // 配置空闲线程存活时间
//        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
//        // 配置线程池中的线程的名称前缀
//        executor.setThreadNamePrefix("async-IO-");
//        //执行初始化
//        executor.initialize();
//        resourceExecutor = TtlExecutors.getTtlExecutor(executor);
//    }
}
