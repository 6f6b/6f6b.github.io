package com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class PostProccessor implements BeanPostProcessor {
    public PostProccessor(){
        System.out.println("PostProccessor initiated");
    }
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization："+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AfterInitialization："+beanName);
        return bean;
    }
}
