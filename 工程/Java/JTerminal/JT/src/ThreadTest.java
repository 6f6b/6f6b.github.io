public class ThreadTest implements Runnable {
    private Thread t;
    private String threadName;

    ThreadTest(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {

        int []numbers = {1,2,3,4,5,6,7,8,9};
        for(int i : numbers){
            System.out.println(threadName+"-----"+i);
            try {
                Thread.sleep(10);
            }catch (Exception e){

            }
        }
    }

    public void start(){
        if (null == t){
            t = new Thread(this,threadName);
        }
        t.start();
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("t1");
        t1.start();
        ThreadTest t2 = new ThreadTest("t2");
        t2.start();
    }
}
