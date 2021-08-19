package com.example.redis_springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuFeng
 * @date 2021/8/19 上午10:26
 */

@RequestMapping(value = "/redis")
@RestController
public class RedisController {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @GetMapping
    public String testRedis(){
//        //分布式锁（太慢了）
//        while (!redisTemplate.opsForValue().setIfAbsent("lock","",10, TimeUnit.SECONDS)){
//        }
        int num = (Integer) redisTemplate.opsForValue().get("num");
        if (num > 0){
            redisTemplate.opsForValue().decrement("num");
            System.out.println("抢购成功");
        }else{
            System.out.println("抢购失败");
        }
        redisTemplate.delete("lock");
        List<Object> results = redisTemplate.exec();
        System.out.println("释放锁"+redisTemplate.opsForValue().get("lock"));
        return "success";
    }

}
