package com.example.quartzdemo.jobs;

import com.example.quartzdemo.QuartzDemoApplication;
import com.example.quartzdemo.dao.SchedulerJob;
import com.example.quartzdemo.repository.TaskRepository;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

public class BaseJob implements Job {
    private Logger logger = LoggerFactory.getLogger(BaseJob.class);
    private TaskRepository taskRepository;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        CronTrigger cronTrigger = (CronTrigger) jobExecutionContext.getTrigger();
        String cronExpression = cronTrigger.getCronExpression();
        logger.info("执行触发器：("+cronExpression+")");
        taskRepository = QuartzDemoApplication.applicationContext.getBean(TaskRepository.class);
        Collection<JobResolver> jobResolvers = QuartzDemoApplication.applicationContext.getBeansOfType(JobResolver.class).values();
        List<SchedulerJob> schedulerJobs = taskRepository.findSchedulerJobsByCronexpression(cronExpression);
        if (schedulerJobs.stream().count() == 0){
            JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
            Scheduler scheduler = jobExecutionContext.getScheduler();
            try {
                scheduler.deleteJob(jobKey);
                logger.info("工作数为0，销毁触发器("+cronExpression+")");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            schedulerJobs.forEach((schedulerJob)->{
                if (schedulerJob.getStatus() == 1){
                    jobResolvers.forEach((jobResolver)->{
                        jobResolver.excute(schedulerJob.getJobContent());
                    });
                }
            });
        }
    }
}
