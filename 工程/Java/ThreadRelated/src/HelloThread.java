import java.util.ArrayList;
import java.util.concurrent.Future;

public class HelloThread implements Runnable{
    public int age = 0;
    @Override
    public void run() {
        System.out.println("this is the start of Thread");
        //设置当前线程为打断状态
        Thread.currentThread().interrupt();

        //返回当前线程是否被打断，并不清空状态
        Thread.currentThread().isInterrupted();

        //返回当前线程是否被打断，并将状态清空
        Thread.interrupted();
        System.out.println("this is the end of Thread");
    }

    public static void main(String[] args) throws InterruptedException{
//        System.out.println("This is main method start");
//        new Thread(new HelloThread()).start();
//        Thread t = new HeyThread();
//        t.start();
//        //当使用join并传入时间参数时，你不能假设他刚好就阻塞3000毫秒，这受到操作系统能力的影响；而当不传入参数时可以保证其阻塞至t这个线程结束
//        t.join(3000);
//        System.out.println("This is main method teminated");
        TrainStation ticketCenter = new TrainStation();
        int stationNum = 20;
        System.out.println(String.format("总计%d张票,%d个窗口同时取票",ticketCenter.ticketNum,stationNum));
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i=0;i<stationNum;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (ticketCenter.ticketNum > 0){
                        ticketCenter.acquireTicket();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(String.format("%s-取票失败",Thread.currentThread().getName()));
                }
            });
            t.start();
            threads.add(t);
        }
        for (int i = 0; i < threads.size(); i++) {
            System.out.println("join");
            threads.get(i).join();
        }
        System.out.println("票已被取完");

    }
}
