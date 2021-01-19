package com.example.quartzdemo.dao;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cron_expression")
    private String cronExpression;

    @Column(name = "status")
    private Integer status;

    @Column(name = "start_time")
    private  long startTime;

    @Column(name = "next_time")
    private  long nextTime;

    @Column(name = "end_time")
    private  long endTime;

    public Job(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronexpression(String cronexpression) {
        this.cronExpression = cronexpression;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getNextTime() {
        return nextTime;
    }

    public void setNextTime(long nextTime) {
        this.nextTime = nextTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getJobName(){
        return "job_name_" + this.getCronExpression();
    }

    public String getJobGroup(){
        return "job_group_" + this.getCronExpression();
    }

    public String getTriggerName(){
        return "trigger_name_" + this.getCronExpression();
    }

    public String getTriggerGroup(){
        return "trigger_group_" + this.getCronExpression();
    }

    public String getDescription(){
        return "description_" + this.getCronExpression();
    }
}
