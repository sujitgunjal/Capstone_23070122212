// Priority Queue (Min heap)
// Arraylist
// Min heap (parent element is <= all other elements)

import java.util.*;

class ListNode402{
    int val;
    ListNode402 next;

    ListNode402(int val){
        this.val = val;
        this.next = null;
    }
}

public class SIT_402 {
    public static void main(String[] args) {
        // Create list 1: 1 --> 4 --> 5
        ListNode402 l1 = new ListNode402(1);
        l1.next = new ListNode402(4);
        l1.next.next = new ListNode402(5);

        // Create list 2: 1 --> 3 --> 4
        ListNode402 l2 = new ListNode402(1);
        l2.next = new ListNode402(3);
        l2.next.next = new ListNode402(4);

        // Create list 3: 2 --> 6
        ListNode402 l3 = new ListNode402(2);
        l3.next = new ListNode402(6);

        ListNode402[] lists = {l1, l2, l3};

        ListNode402 result = mergeLists(lists);

        printList(result);
    }

    static void printList(ListNode402 head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    static ListNode402 mergeLists(ListNode402[] lists){
        PriorityQueue<ListNode402> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode402 head : lists){
            if(head != null){
                pq.add(head);
            }
        }

        ListNode402 dummy = new ListNode402(-1);
        ListNode402 tail = dummy;

        while(!pq.isEmpty()){
            ListNode402 node = pq.poll();
            tail.next = node;
            tail = tail.next;

            if(node.next != null){
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}

// Time Complexity O(N log k) where N is the total number of nodes and k is the number of linked lists