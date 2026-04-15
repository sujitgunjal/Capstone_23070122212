class Table_SIT // Synchronization
{
    synchronized void printTable(int num) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i * num);
        }
    }
}

class Five_SIT extends Thread { // Multithreading
    Table_SIT F;

    Five_SIT(Table_SIT op) {
        this.F = op;
    }

    public void run() {
        F.printTable(5);
    }
}

class Seven_SIT extends Thread { // Multithreading
    Table_SIT S;

    Seven_SIT(Table_SIT op) {
        this.S = op;
    }

    public void run() {
        S.printTable(7);
    }
}

public class SIT_604 {
    public static void main(String[] args) {
        Table_SIT op = new Table_SIT();

        Five_SIT t1 = new Five_SIT(op);
        Seven_SIT t2 = new Seven_SIT(op);

        t1.start();
        t2.start();
    }
}