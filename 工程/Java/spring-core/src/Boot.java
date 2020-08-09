import com.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boot {

    public static void main(String[] args) {
        //LeetCode leetCode = new LeetCode();
        ApplicationContext context = new ClassPathXmlApplicationContext("com/resource/common.xml");
        Person mao = context.getBean("maozedong",Person.class);
        System.out.println(mao.name);
        System.out.println(mao.dog.name);

        Person liufeng = context.getBean("liufeng",Person.class);
        System.out.println(liufeng.name);
        System.out.println(liufeng.dog.name);

    }

}
