package com.example.quartzdemo.service;

import com.example.quartzdemo.dao.Job;

import java.math.BigInteger;

public interface QuartzService {
    /**
     * 创建调度
     *
     * @param job
     * @return
     */
    Job addJob(Job job) throws Exception;

    /**
     * 修改调度
     *
     * @param job
     */
    void updateJob(Job job) throws Exception;

    /**
     * 删除调度
     *
     * @param id
     */
    void deleteJob(Long id);

    /**
     * 查询调度
     *
     * @param id
     */
    Job selectJob(Long id);

    /**
     * 添加一个调度器
     */
    void addSchedule(String cronExpression);

    void run();
}
