// Online calculator
// t1 = 5 Table of 5 should be printed
// t2 = 7 Table of 7 should be printed

// It should be synchronized, and following steps should be used.
// Multithreading
// Step 1: import java.lang pkg.
// Step 2: A) By extending the Thread class
//         B) By implementing the Runnable interface (best approach)
// Step 3: Initialize the run() method
// Step 4: 
// Step 5: Implemented the run() method. (Most imp method)
// Step 6: Create the number of threads.
// Step 7: Start all the threads.

// The output should be synchronized, meaning that the tables should not interleave.

class TableSIT_603 extends Thread {
    int num;
    static Object lock = new Object();

    TableSIT_603(int number) {
        this.num = number;
    }

    public void run() {
        synchronized(lock) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is printing the table of " + num);
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }
        }
    }
}

public class SIT_603 {
    public static void main(String[] args) {
        TableSIT_603 t1 = new TableSIT_603(5);
        TableSIT_603 t2 = new TableSIT_603(7);

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}