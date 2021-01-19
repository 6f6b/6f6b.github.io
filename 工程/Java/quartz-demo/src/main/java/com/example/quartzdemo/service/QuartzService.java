package com.example.quartzdemo.service;

import com.example.quartzdemo.dao.Job;

import java.math.BigInteger;

public interface QuartzService {
    /**
     * 创建调度
     * @param job
     * @return
     */
    public Job addJob(Job job) throws Exception;

    /**
     * 修改调度
     * @param job
     */
    public void updateJob(Job job) throws Exception;

    /**
     * 删除调度
     * @param id
     */
    public void deleteJob(Long id);

    /**
     * 查询调度
     * @param id
     */
    public Job selectJob(Long id);

    /**
     * 添加一个调度器
     */
    public void addSchedule(String cronExpression);
}
