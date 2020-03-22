package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.mapper.UserMapper;
import com.example.mybatisdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //表示这个controller下的所有请求都返回json
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> list(){
//        List list = new ArrayList();
//        list.add(new User());
//        return list;
        return userMapper.list();
    }
}
