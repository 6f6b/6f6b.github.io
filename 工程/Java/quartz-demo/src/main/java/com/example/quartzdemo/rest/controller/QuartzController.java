package com.example.quartzdemo.rest.controller;

import com.example.quartzdemo.dao.Job;
import com.example.quartzdemo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/quartz")
public class QuartzController {
    @Autowired
    private QuartzService quartzService;


    @RequestMapping("/add")
    //@ApiOperation("创建Quartz任务")
    public String addJob(@RequestBody Job job) throws Exception{
        quartzService.addJob(job);
        return "创建Quartz任务成功";
    }

    @RequestMapping("/update")
    //@ApiOperation("修改Quartz任务")
    public String updateJob(@RequestBody Job job) throws Exception{
        if(job==null) throw new Exception("job is null");
        quartzService.updateJob(job);
        return "修改Quartz任务成功";
    }

    @RequestMapping("/delete")
    //@ApiOperation("删除Quartz任务")
    public String deleteJob(@RequestParam Long id) throws Exception{
        if(id==null) throw new Exception("id cannot be null");
        quartzService.deleteJob(id);
        return "删除Quartz任务成功";
    }

    @RequestMapping("/select")
    //@ApiOperation("获取Quartz任务")
    public Job selectJob(@RequestParam Long id) throws Exception{
        if(id==null) throw new Exception("id cannot be null");
        Job selectJob = quartzService.selectJob(id);
        return selectJob;
    }
}
