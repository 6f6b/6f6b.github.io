package com.liu.springtest.start.configuration;

import com.liu.springtest.start.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public MyService myService(){
        return new MyService();
    }
}
