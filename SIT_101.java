//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Diamond Problem
// Java does not support multiple inheritance of classes
// so this topic is usually demonstrated using interfaces.
// Q: A smart home system has Device A and Device B, both the system have same operation
// that is turnOn
// sol: SmartDevice implements both method/interfaces.

interface DeviceA_SIT{
    default void turnOn(){
        System.out.println("Device A is ON.");
    }
}
interface DeviceB_SIT{
    default void turnOn(){
        System.out.println("Device B is ON.");
    }
}

class SmartDevice implements DeviceA_SIT,DeviceB_SIT{
    public void turnOn(){
        DeviceA_SIT.super.turnOn();
        DeviceB_SIT.super.turnOn();
    }
}
public class SIT_101 {
    public static void main(String[] args) {

    }
}