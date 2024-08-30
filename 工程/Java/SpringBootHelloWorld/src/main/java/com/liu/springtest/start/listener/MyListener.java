package com.liu.springtest.start.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.print("上下文被创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.print("上下文被销毁");
    }
}
