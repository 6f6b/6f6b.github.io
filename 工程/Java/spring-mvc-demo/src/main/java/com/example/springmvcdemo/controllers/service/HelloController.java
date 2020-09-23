package com.example.springmvcdemo.controllers.service;

import com.example.springmvcdemo.aop.aspect.WebLog;
import com.example.springmvcdemo.utils.LocalUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
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
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private ApplicationContext applicationContext;
    String name;
    Integer age;
    Map<String,String> map;

    @Autowired
    MessageSource messageSource;

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
    public String handle() throws InterruptedException {
        logger.info("正在处理业务");
        Thread.sleep(7000);
        String message = "hello im feng";
        logger.info("处理业务结束");
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

    @WebLog
    @RequestMapping("exit")
    public void exit(){
        SpringApplication.exit(this.applicationContext);
    }
}
