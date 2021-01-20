package com.example.quartzdemo.jobs;

import com.example.quartzdemo.QuartzDemoApplication;
import com.example.quartzdemo.dao.Job;
import com.example.quartzdemo.repository.JobRepository;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class BaseJob  implements org.quartz.Job {
    private Logger logger = LoggerFactory.getLogger(BaseJob.class);
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private List<JobResolver> jobResolvers;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        CronTrigger cronTrigger = (CronTrigger) jobExecutionContext.getTrigger();
        String cronExpression = cronTrigger.getCronExpression();
        logger.info("执行调度：("+cronExpression+")");
//        jobRepository = QuartzDemoApplication.applicationContext.getBean(JobRepository.class);

//        Collection<JobResolver> jobResolvers = QuartzDemoApplication.applicationContext.getBeansOfType(JobResolver.class).values();
        long currentTime = System.currentTimeMillis();
        List<Job> jobs = jobRepository.findSchedulerJobs(cronExpression,currentTime);
        if (jobs.stream().count() == 0){
            JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
            Scheduler scheduler = jobExecutionContext.getScheduler();
            try {
                scheduler.deleteJob(jobKey);
                logger.info("工作数为0，移除调度器("+cronExpression+")");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            jobs.forEach((schedulerJob)->{
                //更新next_time
                Date nextTime = cronTrigger.getNextFireTime();
                Integer succeedNum = jobRepository.update(schedulerJob.getId(),nextTime.getTime());
                if (succeedNum >= 1){
                    jobResolvers.forEach((jobResolver)->{
                        jobResolver.excute(schedulerJob.getId());
                    });
                }
            });
        }
    }
}
