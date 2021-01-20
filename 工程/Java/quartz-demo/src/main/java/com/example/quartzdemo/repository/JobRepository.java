package com.example.quartzdemo.repository;

import com.example.quartzdemo.dao.Job;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface JobRepository extends CrudRepository<Job,Long> {
    @Query(value = "SELECT cron_expression FROM jobs GROUP BY cron_expression",nativeQuery = true)
    public List<String> findAllCronExpressions();

    @Query(value = "SELECT * FROM jobs WHERE status = 1 AND cron_expression = :cron AND start_time < :currentTime AND next_time <= :currentTime AND (end_time > :currentTime OR end_time = 0)",nativeQuery = true)
    public List<Job> findSchedulerJobs(@Param("cron") String cronExpression, @Param("currentTime") long currentTime);

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(value = "UPDATE jobs SET status = :status,start_time = :start_time,next_time = :next_time,end_time = :end_time,cron_expression = :cron WHERE id = :id",nativeQuery = true)
    public void update(@Param("id") Long id, @Param("status") Integer status, @Param("start_time") long startTime, @Param("next_time") long nextTime, @Param("end_time") long endTime, @Param("cron") String cronExpression);

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(value = "UPDATE jobs SET next_time = :next_time WHERE id = :id AND next_time < :next_time",nativeQuery = true)
    public Integer update(@Param("id")Long id,@Param("next_time") long nextTime);
}
