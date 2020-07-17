import com.CustomEnvironment;
import com.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

public class Boot {
//    @Autowired
//    Environment environment;

    public static void main(String[] args) {
        PropertySource()
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("/com");
        ctx.getEnvironment().setActiveProfiles("development");
        TestBean testBean = ctx.getBean("testBean",TestBean.class);
        testBean.sayHello();
        CustomEnvironment environment = ctx.getBean("customEnvironment",CustomEnvironment.class);
        System.out.println(environment.env);
    }
}
