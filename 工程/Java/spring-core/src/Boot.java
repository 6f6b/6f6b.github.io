import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boot {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/apps.xml");
        TestBean testBean = ctx.getBean("testBean",TestBean.class);
        testBean.sayHello();
    }
}
