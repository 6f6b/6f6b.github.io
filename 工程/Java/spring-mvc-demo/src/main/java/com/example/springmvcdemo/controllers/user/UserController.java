package com.example.springmvcdemo.controllers.user;

import com.example.springmvcdemo.aop.aspect.WebLog;
import com.example.springmvcdemo.dao.MyService;
import com.example.springmvcdemo.dao.RestResponse;
import com.example.springmvcdemo.entity.User;
import com.example.springmvcdemo.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Api(tags = {"用户信息API"})
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyService service;

    @PostMapping(path = "/add")
    @WebLog
    @ApiOperation(value = "添加用户")
    public ResponseEntity<RestResponse<Void>> createUser(@RequestParam String name, @RequestParam String address){
        String message;
        if (name == null){
            message = "name 不能为空";
        }
        else if (address == null){
            message = "address 不能为空";
        }else{
            User user = new User();
            user.setName(name);
            user.setAddress(address);
            User result = userRepository.save(user);

            if (result != null){
                message = "创建成功！";
            }else{
                message = "创建失败！";
            }
        }
        return handleWith(message, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    @ApiOperation(value = "获取所有用户")
    @WebLog
    public ResponseEntity<RestResponse<Iterable<User>>> all(){
        service.simulateSlowService();
        return handleWith(userRepository.findAll(),HttpStatus.OK);
    }

    private<T> ResponseEntity handleWith(T body,HttpStatus status){
        RestResponse<T> restResponse = new RestResponse<>(body);
        ResponseEntity<RestResponse<T>> entity = new ResponseEntity(restResponse, status);
        return entity;
    }
    private<T> ResponseEntity handleWith(String message,HttpStatus status){
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setMessage(message);
        ResponseEntity<RestResponse<T>> entity = new ResponseEntity(restResponse, status);
        return entity;
    }
}
