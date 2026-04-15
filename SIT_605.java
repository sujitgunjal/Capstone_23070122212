// Bank Withdraw
// Static synchronization

class Bank_605 extends Thread {

    static int withdraw;
    static int balance = 5000;

    Bank_605(int withdraw) {
        this.withdraw = withdraw;
    }

    public void run() {
        symbi();
    }

    public static synchronized void symbi() {
        String name = Thread.currentThread().getName();
        if (balance >= withdraw) {
            System.out.println(name + " Withdrawn: " + withdraw);
            balance = balance - withdraw;
        } else {
            System.out.println(name + " Sorry, not enough balance available.");
        }
    }
}

public class SIT_605 {
    public static void main(String[] args) {
        Bank_605 op = new Bank_605(2000);

        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        Thread t3 = new Thread(op);
        Thread t4 = new Thread(op);

        t1.setName("Onkar");
        t2.setName("Subham");
        t3.setName("Rahul");
        t4.setName("Amit");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}