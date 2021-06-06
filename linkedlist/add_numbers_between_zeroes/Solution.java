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

    private static void solve() {
        Node head = new Node(3);
                head.next = new Node(2);
                head.next.next = new Node(0);
                head.next.next.next = new Node(4);
                head.next.next.next.next = new Node(5);
                head.next.next.next.next.next = new Node(0);
                head.next.next.next.next.next.next = new Node(6);
                head.next.next.next.next.next.next.next = new Node(7);

        printList(head);

        Node temp = head;
        Node res = head;

        int sum = 0;

        while (temp != null) {
            if (temp.data != 0) {
                sum += temp.data;
                temp = temp.next;
            } else {
                res.data = sum;
                res.next = temp.next;
                res = res.next;
                temp = temp.next;
                sum = 0;
            }
        }

        printList(head);

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