public class HelloThread implements Runnable{
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
        System.out.println("This is main method start");
        new Thread(new HelloThread()).start();
        Thread t = new HeyThread();
        t.start();
        //当使用join并传入时间参数时，你不能假设他刚好就阻塞3000毫秒，这受到操作系统能力的影响；而当不传入参数时可以保证其阻塞至t这个线程结束
        t.join(3000);
        System.out.println("This is main method teminated");
    }
}
