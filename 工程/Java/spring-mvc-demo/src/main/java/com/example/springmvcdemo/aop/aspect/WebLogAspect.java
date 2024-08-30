package com.example.springmvcdemo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger          = LoggerFactory.getLogger(WebLogAspect.class);
    private static final String LINE_SEPARATER  = System.lineSeparator();

    @Pointcut("@annotation(WebLog)")
    public void webLog(){}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        logger.info("Response Args : {}",result.toString());
        logger.info("Time Consuming : {} ms",System.currentTimeMillis() - startTime);
        logger.info("=========================end=========================");
        return result;
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        //开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder. getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //String methodDescription = getAspectLogDescription (joinPoint);
        logger.info("=========================start=========================");
        logger.info("URL            :{}",request.getRequestURL().toString());
        logger.info("HTTP Method    :{}",request.getMethod());
        logger.info("Class Method   :{}.{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature());
        logger.info("IP             :{}",request.getRemoteAddr());
        logger.info("Request args   :{}",joinPoint.getArgs().toString());
    }
}
