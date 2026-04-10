// Q: Employee management system (Diamond structure): This is the classic structure A->B, C->D structure

// Q: Create a real-time employee notification system
// A = Employee
// B = Email Notification
// C = SMS Notification
// D = Manager
// Both B & C inherit from A

interface Employee{
    void notifyEmployee();
}

interface EmailNotification{
    default void notifyEmployee(){
        System.out.println("Notification sent via Email");
    }
}

interface SMSNotification{
    default void notifyEmployee(){
        System.out.println("Notification sent via SMS");
    }
}

public class SIT_103 {
    public static void main(String[] args) {

    }
}