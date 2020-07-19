import com.CustomEnvironment;
import com.TestBean;
import com.pulisher.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public class Boot {
//    @Autowired
//    Environment environment;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("/com");
        ctx.getEnvironment().setActiveProfiles("development");
        TestBean testBean = ctx.getBean("testBean",TestBean.class);
        testBean.sayHello();
        CustomEnvironment environment = ctx.getBean("customEnvironment",CustomEnvironment.class);
        System.out.println(environment.env);

        EmailService emailService = ctx.getBean("emailService",EmailService.class);
        ArrayList<String> list = new ArrayList<>();
        list.add("993371649@qq.com");
        emailService.setBlackList(list);
        emailService.sendEmail("993371649@qq.com","hello liufeng");
    }
}
