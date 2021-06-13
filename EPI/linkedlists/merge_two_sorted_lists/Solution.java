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


    // Merge two sorted linkedlists
    private static void solve() {
        Node head = new Node(2);
                head.next = new Node(2);
                head.next.next = new Node(3);
                head.next.next.next = new Node(4);
                head.next.next.next.next = new Node(11);
                head.next.next.next.next.next = new Node(12);
                head.next.next.next.next.next.next = new Node(26);
                head.next.next.next.next.next.next.next = new Node(37);

        Node head2 = new Node(1);
                head2.next = new Node(4);
                head2.next.next = new Node(5);
                head2.next.next.next = new Node(10);
                head2.next.next.next.next = new Node(13);
                head2.next.next.next.next.next = new Node(30);
                head2.next.next.next.next.next.next = new Node(32);


        printList(head);
        printList(head2);

        Node result = new Node(-1);

        Node temp = head;
        Node temp2 = head2;
        Node temp3 = result;

        while (temp != null && temp2 != null) {
            if (temp.data >= temp2.data) {
                temp3.next = new Node(temp2.data);
                temp2 = temp2.next;
                temp3 = temp3.next;
            } else {
                temp3.next = new Node(temp.data);
                temp = temp.next;
                temp3 = temp3.next;
            }
        }

        while (temp != null) {
            temp3.next = new Node(temp.data);
            temp = temp.next;
            temp3 = temp3.next;
        }

        while (temp2 != null) {
            temp3.next = new Node(temp2.data);
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        result = result.next;

        printList(result);
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