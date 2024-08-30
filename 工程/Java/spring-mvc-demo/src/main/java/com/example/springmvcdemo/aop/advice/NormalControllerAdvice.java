package com.example.springmvcdemo.aop.advice;

import com.example.springmvcdemo.aop.aspect.WebLog;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class NormalControllerAdvice {
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    public String arrayIndexOutOfBoundException(ArrayIndexOutOfBoundsException ex){
        return ex.toString()+"数组越界";
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String nullPointerException(NullPointerException ex){
        return ex.toString()+"空指针";
    }

    @ModelAttribute(name = "mymap")
    public Map<String,Object> myData(){
        Map<String,Object> map = new HashMap<>();
        map.put("creater","liufeng");
        return map;
    }

    @InitBinder
    public void prebind(WebDataBinder binder){
//        String str = binder.toString();
//        System.out.println(str);
    }
}
