package com.keespo.juner.controller;

import com.keespo.juner.entities.Response;
import com.keespo.juner.entities.User;
import com.keespo.juner.entities.UserSession;
import com.keespo.juner.repository.UserRepository;
import com.keespo.juner.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @PostMapping(path = "/user")
    @ResponseBody
    public Response<UserSession> register(@RequestParam String phone, @RequestParam String password){
        Response<UserSession> response = new Response<UserSession>(0,"注册失败",null);

        if (phone.length() > 0 && password.length() > 0){
            User exsistUser = userRepository.findUserByPhone(phone);
            if (exsistUser != null){
                response = new Response<UserSession>(0,"该用户已存在",null);
                return response;
            }
            User user = new User();
            user.setPhone(phone);
            user.setPassword(password);
            userRepository.save(user);

            response = login(phone,password);
            response.setMessage("注册成功");
            return response;
        }
        return response;
    }

    @GetMapping(path = "/session")
    public Response<UserSession> login(@RequestParam String phone,@RequestParam String password){
        Response<UserSession> response = new Response<>(0,"登录失败",null);
        User exsistUser = userRepository.findUserByPhone(phone);
        if (exsistUser.getPassword().equals(password)){
            UserSession session = userSessionRepository.findUserSessionByUserId(exsistUser.getId());
            if (session == null){
                session = new UserSession();
                session.setUserId(exsistUser.getId());
            }
            String sessionId = generateSession();
            session.setSession(sessionId);
            userSessionRepository.save(session);
            response = new Response<>("登录成功",session);
            return response;
        }
        return response;
    }

    //获取用户信息
    @GetMapping(path = "/userInfo")
    public Response<User> userInfo(HttpServletRequest request,HttpServletResponse respon){
        Response<User> response = new Response<User>(0,"登录信息已过期",null);
        String sessionId = request.getHeader("session");
        if (sessionId == null){
            return  response;
        }
        UserSession session = userSessionRepository.findUserSessionBySession(sessionId);
        if (session == null){
            return response;
        }
        User user = userRepository.findUserById(session.getUserId());
        if (user == null){
            return response;
        }
        user.setPassword(null);
        response = new Response<User>(user);
        return response;
    }

    //更新用户信息
    @PostMapping(path = "/userInfo")
    public Response<User> updateUserInfo(HttpServletRequest request){

        Response<User> response = new Response<>(0,"登录信息已过期",null);
        String sessionId = request.getHeader("session");
        if (sessionId == null){
            return  response;
        }
        UserSession session = userSessionRepository.findUserSessionBySession(sessionId);
        if (session == null){
            return response;
        }
        User user = userRepository.findUserById(session.getUserId());
        if (user == null){
            return response;
        }
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String portraint = request.getParameter("portraint");
        if (name != null){
            user.setName(name);
        }
        if (address != null){
            user.setAddress(address);
        }
        if (portraint != null){
            user.setPortraint(portraint);
        }
        userRepository.save(user);
        user.setPassword(null);
        response = new Response<>(user);
        return response;
    }

    private String generateSession(){
        int length = 16;
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
