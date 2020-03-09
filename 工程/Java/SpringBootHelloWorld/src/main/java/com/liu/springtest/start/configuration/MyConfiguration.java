package com.liu.springtest.start.configuration;

import com.liu.springtest.start.filter.MyFilter;
import com.liu.springtest.start.listener.MyListener;
import com.liu.springtest.start.service.MyService;
import com.liu.springtest.start.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;

@Configuration
//配置类，相当于之前的配置文件
//<beans>
//    <bean id="" class = ""></bean>
//</beans>
public class MyConfiguration {
    @Bean
    //把这个对象交给容器进行管理，什么容器？怎么管理？管理来干什么
    //等价于<bean id="xxx" class="xxx.xxx.xxx.MyService"></bean>
    //@Bean相当于在配置文件中配置了一个bean节点
    //方法的返回值相当于class
    //方法名相当于id
    public MyService myService() {
        return new MyService();
    }

    /*注册servlet*/
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return servletRegistrationBean;
    }

    /*注册Filter*/
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        //设置过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/myServlet");
        //Tina
        return filterRegistrationBean;
    }

    /*注册Listener*/
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }
}
