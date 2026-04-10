import java.util.Scanner;

interface UPIPayment{
    default void processPayment(){
        System.out.println("Payment done using UPI.");
    }
}

interface CardPayment{
    default void processPayment(){
        System.out.println("Payment done using Card.");
    }
}

class HybridPayment implements UPIPayment,CardPayment{
    Scanner sc = new Scanner(System.in);
    public void processPayment(){
        System.out.println("Choose payment method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.print("Choice:");
        int ch = sc.nextInt();
        if(ch==1){
            UPIPayment.super.processPayment();
        }
        else if(ch==2){
            CardPayment.super.processPayment();
        }
        else{
            System.err.println("Invalid choice.");
        }
    }
}

public class SIT_102 {
    public static void main(String[] args) {
        HybridPayment hp = new HybridPayment();
        hp.processPayment();
    }
}
