package com.liufeng.thymeleaf.controller;

import com.liufeng.thymeleaf.mode.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("text","这是一个个很牛逼的事情");
        return "hello";
    }

    @RequestMapping("user")
    public String user(Model model, HttpSession session){
        User user = new User("liufeng",19,"阆中市峰站详细奥运村");
        model.addAttribute("user",user);

        session.setAttribute("user","liufeng");
        return "user";
    }

    @RequestMapping("userList")
    public String userList(Model model){
        List users = new ArrayList();
        users.add(new User("liufeng01",13,"成都"));
        users.add(new User("liufeng02",14,"成都"));
        users.add(new User("liufeng03",15,"成都"));
        users.add(new User("liufeng04",16,"成都"));
        users.add(new User("liufeng05",17,"成都"));
        model.addAttribute("users",users);
        return "userList";
    }
}
