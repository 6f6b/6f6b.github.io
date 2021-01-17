package com.example.quartzdemo.service;

import com.example.quartzdemo.dao.SchedulerJob;

public interface QuartzService {

    /**
     * 创建Job
     * @param cronExpression
     * @param jobContent
     */
    public SchedulerJob addTimerJob(String cronExpression,String jobContent);

    /**
     * 修改Job
     * @param job
     */
    public void updateTimerJob(SchedulerJob job);

    /**
     * 删除Job
     * @param id
     */
    public void deleteTimerJob(Integer id);

    /**
     * 查询Job
     * @param id
     */
    public SchedulerJob selectTimerJob(Integer id);

    /**
     * 添加一个触发器
     */
    public void addTrigger(String cronExpression);
}
