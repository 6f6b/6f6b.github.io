package com.example.quartzdemo.rest.controller;

import com.example.quartzdemo.dao.SchedulerJob;
import com.example.quartzdemo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartz")
public class QuartzController {
    @Autowired
    private QuartzService quartzService;


    @RequestMapping("/add")
    //@ApiOperation("创建Quartz任务")
    public String addJob(@RequestParam String cronExpression,String jobContent) throws Exception{
        if(cronExpression.length() == 0) throw new Exception("expression cannot be null");
        quartzService.addTimerJob(cronExpression,jobContent);
        return "创建Quartz任务成功";
    }

    @RequestMapping("/update")
    //@ApiOperation("修改Quartz任务")
    public String updateJob(@RequestBody SchedulerJob job) throws Exception{
        if(job==null) throw new Exception("job is null");
        quartzService.updateTimerJob(job);
        return "修改Quartz任务成功";
    }

    @RequestMapping("/delete")
    //@ApiOperation("删除Quartz任务")
    public String deleteJob(@RequestParam Integer id) throws Exception{
        if(id==null) throw new Exception("id cannot be null");
        quartzService.deleteTimerJob(id);
        return "删除Quartz任务成功";
    }

    @RequestMapping("/select")
    //@ApiOperation("获取Quartz任务")
    public SchedulerJob selectJob(@RequestParam Integer id) throws Exception{
        if(id==null) throw new Exception("id cannot be null");
        SchedulerJob selectTimerJob = quartzService.selectTimerJob(id);
        return selectTimerJob;
    }
}
