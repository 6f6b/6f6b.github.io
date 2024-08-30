public class HeyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("This is thread start from HeyThread");
        String importantInfo[] = {
                "jack",
                "Linda",
                "Michal"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            String info = importantInfo[i];
            System.out.println(info);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("This is thread end from HeyThread");
    }
}
