//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;
public class SIT_201 {

    static void sort(Stack<Integer> s){
        Stack<Integer> tempStack = new Stack<>();

        while(!s.isEmpty()){
            int temp = s.pop();

            while(!tempStack.isEmpty() && tempStack.peek() > temp){
                s.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        System.out.println("Sorted Stack: " + tempStack);
    }
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(34);
        s.push(3);
        s.push(31);
        s.push(98);
        s.push(92);
        s.push(23);

        sort(s);

    }
}