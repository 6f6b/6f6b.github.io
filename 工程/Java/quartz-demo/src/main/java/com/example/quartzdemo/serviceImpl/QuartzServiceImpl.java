package com.example.quartzdemo.serviceImpl;

import com.example.quartzdemo.dao.Job;
import com.example.quartzdemo.jobs.BaseJob;
import com.example.quartzdemo.repository.JobRepository;
import com.example.quartzdemo.service.QuartzService;
import javassist.NotFoundException;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class QuartzServiceImpl implements QuartzService {
    private Logger logger = LoggerFactory.getLogger(QuartzServiceImpl.class);
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private CustomJobFactory customJobFactory;
    @Autowired
    JobRepository repository;
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public Job addJob(Job job) throws Exception{
        Optional<Job> preSchedule = repository.findById(job.getId());
        if (preSchedule.isPresent()){
            throw new ObjectAlreadyExistsException("该任务已存在");
        }
        Job savedJob = repository.save(job);
        addSchedule(savedJob.getCronExpression());
        System.out.println("==================================创建Job成功！==================================");
        return savedJob;
    }



    @Override
    public void updateJob(Job job) throws Exception{
        Optional<Job> preSchedule = repository.findById(job.getId());
        if (!preSchedule.isPresent()){
            throw new NotFoundException("该任务不存在");
        }
        Job savedJob = repository.save(job);
        addSchedule(savedJob.getCronExpression());
        logger.info("==================================更新Job成功！==================================");
    }

    @Override
    public void deleteJob(Long id) {
        repository.deleteById(id);
        logger.info("==================================删除Job！==================================");
    }

    @Override
    public Job selectJob(Long id) {
        Optional<Job> optionalSchedulerJob = repository.findById(id);
        if (optionalSchedulerJob.isPresent()){
            return optionalSchedulerJob.get();
        }
        return null;
    }

    @Override
    public void addSchedule(String cronExpression) {
        try {
            Job job = new Job();
            job.setCronexpression(cronExpression);
            JobDetail jobDetail = JobBuilder
                    .newJob(BaseJob.class)
                    // 指定执行类
                    .withIdentity(job.getJobName(), job.getJobGroup())
                    // 指定name和group
                    .requestRecovery().withDescription(job.getDescription())
                    .build();
            // 创建表达式调度构建器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                    .cronSchedule(job.getCronExpression());
            // 创建触发器
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(job.getTriggerName(), job.getTriggerGroup())
                    .withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();// 触发器并不会立刻触发
        }
        catch (ObjectAlreadyExistsException e){
            logger.info("触发器已存在");
        }
        catch (SchedulerException e){
            e.printStackTrace();
        }
    }

    @PostConstruct
    private void run(){
        customJobFactory.setApplicationContext(applicationContext);
        try {
            scheduler.setJobFactory(customJobFactory);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        logger.info("启动持久化的触发器");
        List<String> cronExpressions = repository.findAllCronExpressions();
        cronExpressions.forEach((cronExpression)->{
            if (null != cronExpression){
                this.addSchedule(cronExpression);
            }
        });
    }
}
