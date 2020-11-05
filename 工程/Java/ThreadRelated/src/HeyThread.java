public class HeyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("This is thread start from HeyThread");
    }
}
