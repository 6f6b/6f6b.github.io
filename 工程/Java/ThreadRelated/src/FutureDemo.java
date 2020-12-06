import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

        AbstractExecutorService executorService ;
        System.out.println("通过");
    }
}
