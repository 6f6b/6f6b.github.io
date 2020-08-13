import com.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class Boot {

    public static void main(String[] args) {
        //LeetCode leetCode = new LeetCode();
        ApplicationContext context = new ClassPathXmlApplicationContext("com/resource/common.xml");
//        GenericApplicationContext context = new GenericApplicationContext();
//        ConfigurableListableBeanFactory factory = context.getBeanFactory();
        Person mao = context.getBean("maozedong",Person.class);

        System.out.println(mao.name);
        System.out.println(mao.dog.name);

        Person liufeng = context.getBean("liufeng",Person.class);
        System.out.println(liufeng.name);
        System.out.println(liufeng.dog.name);
    }

}
