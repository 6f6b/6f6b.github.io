package com.example.springmvcdemo.controllers.service;

import com.example.springmvcdemo.aop.aspect.WebLog;
import com.example.springmvcdemo.del.AcmeProperties;
import com.example.springmvcdemo.utils.LocalUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletContext;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("hello/")
@ConfigurationProperties(prefix = "hello")
@Api(tags = {"Hello Controller","Hello 控制器"})
public class HelloController {
    String name;
    Integer age;
    Map<String,String> map;

    @Autowired
    MessageSource messageSource;

    @Autowired
    private AcmeProperties acmeProperties;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @GetMapping("/hello")
    @WebLog
    @ApiOperation("handle")
    public String handle(@RequestParam(value = "对象",required = true) Object ojc){
        String message = this.messageSource.getMessage("user.login",
                new Object [] {"userDao"}, "Required", Locale.ENGLISH);
        return message;
    }


//
//    @InitBinder
//    protected  void initBinder(WebDataBinder binder){
//        System.out.println(binder.toString());
//    }

    @ExceptionHandler
    @ResponseBody
    public String handle(Exception ex) {
        //ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.ACCEPTED);
        return ex.toString()+"Controller 内的exceptionhandler";
    }
}
