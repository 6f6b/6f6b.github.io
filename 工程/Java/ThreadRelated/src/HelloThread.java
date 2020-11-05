public class HelloThread implements Runnable{
    @Override
    public void run() {
        System.out.println("this is the start of Thread");
    }

    public static void main(String[] args) throws InterruptedException{
        new Thread(new HelloThread()).start();
        new HeyThread().start();

        String importantInfo[] = {
                "jack",
                "Linda",
                "Michal"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            String info = importantInfo[i];
            System.out.println(info);
            Thread.sleep(2000);
        }
    }
}
