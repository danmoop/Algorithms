import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {

    private static FastScanner sc;

    private static class FastScanner {
        private Scanner sc;

        FastScanner() {
            sc = new Scanner(System.in);
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

        public String ns() {
            return sc.next();
        }

        public long nl() {
            return sc.nextLong();
        }

        public double nd() {
            return sc.nextDouble();
        }
    }

    private static void print(Object o) {
        System.out.print(o);
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    private static void ln() {
        print("\n");
    }

    private static void printf(String s, Object... data) {
        System.out.printf(s, data);
    }

    public static void main(String[] args) {
        sc = new FastScanner();

        solve();
    }

    // Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.

    private static void solve() {
        Node head = new Node(1);
        for (int i = 2; i <= 6; i++) {
            insert(head, i);
        }

        head.next.next.next.next = head.next.next.next;
        println(cycleStartMemory(head));
        println(cycleStartPointers(head));
    }

    private static int cycleStartPointers(Node head) {
        Node slow = head;
        Node fast = head.next;
        int cycleLength = 0;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                cycleLength = calculateLength(slow, fast);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = head;
        for (int i = 0; i < cycleLength; i++) {
            fast = fast.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    private static int calculateLength(Node slow, Node fast) {
        slow = slow.next;
        int length = 1;

        while (slow != fast) {
            slow = slow.next;
            length++;
        }

        return length;
    }

    private static int cycleStartMemory(Node head) {
        Map<Node, Boolean> map = new HashMap<>();
        Node temp = head;

        while (temp != null && temp.next != null) {
            if (map.getOrDefault(temp, false)) {
                return temp.data;
            }

            map.put(temp, true);

            temp = temp.next;
        }

        return -1;
    }

    static void insert(Node node, int val) {
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val);
    }

    static void printList(Node head)
    {
        while (head.next != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }

    static class Node {
        int data;
        Node next;
     
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
}