public class ThreadClass extends Thread {


    @Override
    public void run() {
        System.out.println("这是一个新的线程");
    }

    public static void main(String[] args) {
        ThreadClass t = new ThreadClass();
        t.start();
    }
}
