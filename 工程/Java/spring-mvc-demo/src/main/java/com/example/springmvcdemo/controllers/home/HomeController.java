package com.example.springmvcdemo.controllers.home;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api(tags = {"Home","主页"})
public class HomeController {
    @RequestMapping("")
    public String hello(){
        return "hello world !";
    }
}
