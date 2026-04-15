// Bus Booking

class BusSIT_602 extends Thread {
    int available = 5;
    int seat;

    BusSIT_602(int passenger) {
        this.seat = passenger;
    }

    public synchronized void run() {
        String name = Thread.currentThread().getName();
        if (available >= seat) {
            System.out.println(name + " Seats are booked.");
            available = available - seat;
        } else {
            System.out.println(name + " Sorry, not enough seats available.");
        }
    }
}

public class SIT_602 {
    public static void main(String[] args) {
        BusSIT_602 op = new BusSIT_602(2);

        // Number of threads or users
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        Thread t3 = new Thread(op);

        t1.setName("Onkar");
        t2.setName("Subham");
        t3.setName("Ankit");

        t1.start();
        t2.start();
        t3.start();
    }
}