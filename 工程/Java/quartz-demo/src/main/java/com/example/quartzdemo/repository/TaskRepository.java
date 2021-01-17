package com.example.quartzdemo.repository;

import com.example.quartzdemo.dao.SchedulerJob;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends CrudRepository<SchedulerJob,Integer> {
    @Query(value = "SELECT cron_expression FROM tasks GROUP BY cron_expression",nativeQuery = true)
    public List<String> findAllCronExpressions();

    public List<SchedulerJob> findSchedulerJobsByCronexpression(String cronExpression);

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(value = "UPDATE tasks SET status = :status,cron_expression = :cron,task_content = :taskContent WHERE id = :id",nativeQuery = true)
    public void update(@Param("id") Integer id,@Param("status") Integer status,@Param("cron") String cronExpression,@Param("taskContent") String taskContent);

    public List<SchedulerJob> findSchedulerJobsByCronexpressionAndStatus(String cronExpression,Integer status);
}
