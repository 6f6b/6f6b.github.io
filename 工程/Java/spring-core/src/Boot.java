import com.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Boot {

    public static void main(String[] args) {
        //LeetCode leetCode = new LeetCode();
        ApplicationContext context = new ClassPathXmlApplicationContext("com/resource/common.xml");
//        GenericApplicationContext context = new GenericApplicationContext();
//        new XmlBeanDefinitionReader(context).loadBeanDefinitions("com/resource/common.xml");
//        context.refresh();

        Person mao = context.getBean("maozedong",Person.class);
        System.out.println(mao.name);
        System.out.println(mao.dog.name);

        Person liufeng = context.getBean("liufeng",Person.class);
        System.out.println(liufeng.name);
        System.out.println(liufeng.dog.name);

        CommandManager manager = context.getBean("commandManager",CommandManager.class);
        manager.excute();

    }

}
