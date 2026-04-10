class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SIT_202 {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        // Create a cycle: 50 → 20
        head.next.next.next.next.next = head.next;

        // Detect cycle
        if (detectCycle(head)) {
            System.out.println("Cycle detected");
            removeCycle(head);
            System.out.println("Cycle removed");
        } else {
            System.out.println("No cycle");
        }

        // Print list after cycle removal
        printList(head);
    }

    // Floyd’s Cycle Detection Algorithm
    static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Remove cycle
    static void removeCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // First detect cycle
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) return;

        // Move slow to head
        slow = head;

        // Find start of cycle
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Find last node of cycle
        Node prev = fast;
        while (prev.next != slow) {
            prev = prev.next;
        }

        // Break the cycle
        prev.next = null;
    }

    // Print linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}