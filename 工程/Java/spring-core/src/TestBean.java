import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Ap
public class TestBean {
    private String name;
    public TestBean() {
        name = "liufeng";
    }

    public void sayHello(){
        System.out.println(this.name);
    }
}
