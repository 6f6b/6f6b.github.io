package com.example.quartzdemo.dao;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class SchedulerJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cron_expression")
    private String cronexpression;

    @Column(name = "status")
    private Integer status;

    @Column(name = "task_content")
    private String jobContent;

    public SchedulerJob(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCronexpression() {
        return cronexpression;
    }

    public void setCronexpression(String cronexpression) {
        this.cronexpression = cronexpression;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobName(){
        return "job_name_" + this.getCronexpression();
    }

    public String getJobGroup(){
        return "job_group_" + this.getCronexpression();
    }

    public String getTriggerName(){
        return "trigger_name_" + this.getCronexpression();
    }

    public String getTriggerGroup(){
        return "trigger_group_" + this.getCronexpression();
    }

    public String getDescription(){
        return "description_" + this.getCronexpression();
    }

    public SchedulerJob update(SchedulerJob job){
        SchedulerJob.class.getFields();
        if (null != job.getId()){
            this.id = job.getId();
        }
        if (null != job.getStatus()){
            this.status = job.getStatus();
        }
        if (null != job.getCronexpression()){
            this.cronexpression = job.getCronexpression();
        }
        if (null != job.getJobContent()){
            this.jobContent = job.getJobContent();
        }
        return this;
    }
}
