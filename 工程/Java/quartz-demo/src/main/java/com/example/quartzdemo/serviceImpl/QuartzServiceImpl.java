package com.example.quartzdemo.serviceImpl;

import com.example.quartzdemo.dao.SchedulerJob;
import com.example.quartzdemo.jobs.BaseJob;
import com.example.quartzdemo.repository.TaskRepository;
import com.example.quartzdemo.service.QuartzService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Component
public class QuartzServiceImpl implements QuartzService {
    private Logger logger = LoggerFactory.getLogger(QuartzServiceImpl.class);
    @Autowired
    private Scheduler scheduler;
    @Autowired
    TaskRepository repository;

    @Override
    public SchedulerJob addTimerJob(String cronExpression,String jobContent) {
        SchedulerJob job = new SchedulerJob();
        job.setCronexpression(cronExpression);
        job.setJobContent(jobContent);
        job.setStatus(1);
        SchedulerJob savedJob = repository.save(job);
        addTrigger(cronExpression);
        System.out.println("==================================创建Job成功！==================================");
        return savedJob;
    }



    @Override
    public void updateTimerJob(SchedulerJob job) {
        Optional<SchedulerJob> optionalJob = repository.findById(job.getId());
        if (optionalJob.isPresent()){
            SchedulerJob updatedJob = optionalJob.get().update(job);
            repository.update(updatedJob.getId(),updatedJob.getStatus(),updatedJob.getCronexpression(),updatedJob.getJobContent());
            addTrigger(updatedJob.getCronexpression());
            logger.info("==================================更新Job成功！==================================");
        }
    }

    @Override
    public void deleteTimerJob(Integer id) {
        repository.deleteById(id);
        logger.info("==================================删除Job！==================================");
    }

    @Override
    public SchedulerJob selectTimerJob(Integer id) {
        Optional<SchedulerJob> optionalSchedulerJob = repository.findById(id);
        if (optionalSchedulerJob.isPresent()){
            return optionalSchedulerJob.get();
        }
        return null;
    }

    @Override
    public void addTrigger(String cronExpression) {
        try {
            SchedulerJob job = new SchedulerJob();
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
                    .cronSchedule(job.getCronexpression());
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
        logger.info("启动持久化的触发器");
        List<String> cronExpressions = repository.findAllCronExpressions();
        cronExpressions.forEach((cronExpression)->{
            this.addTrigger(cronExpression);
        });
    }
}
