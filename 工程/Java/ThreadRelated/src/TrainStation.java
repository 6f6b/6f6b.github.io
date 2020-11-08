public class TrainStation {
    public int ticketNum = 100;

    public synchronized void acquireTicket(){
        ticketNum -= 1;
        System.out.println(String.format("%s-取一张票，还剩%d张票",Thread.currentThread().getName(),this.acquireTicketNum()));
    }

    public synchronized int acquireTicketNum(){
        return ticketNum;
    }
}
