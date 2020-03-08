package com.liu.springtest.start.configuration;

import com.liu.springtest.start.intecepter.MyIntecepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration2 implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置自定义拦截器，指定该拦截器的拦截路径
        registry.addInterceptor(new MyIntecepter()).addPathPatterns("/list");
        //如果有其他拦截器，继续add
    }
}
