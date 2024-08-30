public class ThreadExample implements Runnable{
    static void threadMessage(String message){
        Thread thread = Thread.currentThread();
        System.out.println(String.format("%s:%s",thread.getName(),message));
    }

    @Override
    public void run() {
            String[] importantInfos = {
                    "info 1",
                    "info 2",
                    "info 3",
                    "info 4"
            };
        for (int i = 0; i < importantInfos.length; i++) {
            String info = importantInfos[i];
            threadMessage(info);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                threadMessage("I wasn't down !");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(new ThreadExample());
        t.wait();
        t.start();
        t.notify();
        long patience = 4000;
        long startTime = System.currentTimeMillis();
        while (t.isAlive()){
            threadMessage("Still waiting ...");
            t.join(1000);
            if (System.currentTimeMillis()-startTime > patience){
                threadMessage("Tired of waiting !!");
                t.interrupt();
                //这里进行无限期的等待，等待这个线程中断退出
                t.join();
            }
        }
        threadMessage("Finally !");
    }
}
