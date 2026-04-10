// Jack is always excited about Sunday, it is his favourite day as he gets to play all day and goes cycling with his friends.
// So everytime the month starts, he counts the number of Sundays he will get to enjoy. Now considering the month can start
// with any day of the week, count the number of Sundays Jack will get within N number of days.

import java.util.Scanner;

public class SIT_106 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the starting day of the month:");
        String startDay = sc.next().trim().toLowerCase();
        System.out.println("Enter the number of days in the month:");
        int n = sc.nextInt();

        int startIndex;
        switch (startDay) {
            case "sunday":
                startIndex = 0;
                break;
            case "monday":
                startIndex = 1;
                break;
            case "tuesday":
                startIndex = 2;
                break;
            case "wednesday":
                startIndex = 3;
                break;
            case "thursday":
                startIndex = 4;
                break;
            case "friday":
                startIndex = 5;
                break;
            case "saturday":
                startIndex = 6;
                break;
            default:
                System.out.println("Invalid day");
                sc.close();
                return;
        }

        int sundayCount = 0;
        for (int i = 0; i < n; i++) {
            if ((startIndex + i) % 7 == 0) {
                sundayCount++;
            }
        }

        System.out.println(sundayCount);
        sc.close();
    }
}