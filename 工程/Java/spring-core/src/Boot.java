import com.CustomEnvironment;
import com.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Boot {
//    @Autowired
//    Environment environment;

    public static void main(String[] args) {
        PropertySource()
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("/com");
        ctx.getEnvironment().setActiveProfiles("development");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/apps.xml");
        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext();
//        actx.register();
        TestBean testBean = ctx.getBean("testBean",TestBean.class);
        testBean.sayHello();
        CustomEnvironment environment = ctx.getBean("customEnvironment",CustomEnvironment.class);
        System.out.println(environment.env);
    }
}
