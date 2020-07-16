import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Boot {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/apps.xml");
        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext();
//        actx.register();
        TestBean testBean = ctx.getBean("testBean",TestBean.class);
        testBean.sayHello();
    }
}
