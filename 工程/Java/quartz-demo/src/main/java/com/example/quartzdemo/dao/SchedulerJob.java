package com.example.quartzdemo.dao;


import java.util.Date;

public class SchedulerJob {

    //@ApiModelProperty(value="jobid",dataType="String",name="jobid",example="1")
    private String jobid;

    //@ApiModelProperty(value="classname",dataType="String",name="classname",example="com.bcu.springboot.biz.quartz.CustomJob")
    private String classname;

    //@ApiModelProperty(value="cronexpression",dataType="String",name="cronexpression",example="0/5 * * * * ?")
    private String cronexpression;

    //@ApiModelProperty(value="jobname",dataType="String",name="jobname",example="job1")
    private String jobname;

    //@ApiModelProperty(value="jobgroup",dataType="String",name="jobgroup",example="group1")
    private String jobgroup;

    //@ApiModelProperty(value="triggername",dataType="String",name="triggername",example="triggername1")
    private String triggername;

    //@ApiModelProperty(value="triggergroup",dataType="String",name="triggergroup",example="triggergroup1")
    private String triggergroup;

    //@ApiModelProperty(value="pause",dataType="Boolean",name="pause",example="true")
    private Boolean pause;

    private Boolean enable;

    //@ApiModelProperty(value="description",dataType="String",name="description",example="秒杀活动")
    private String description;

    private Date createtime;

    private Date lastupdatetime;


}
