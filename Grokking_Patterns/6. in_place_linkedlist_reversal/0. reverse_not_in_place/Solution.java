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
        Node head = new Node(1);
        for (int i = 2; i <= 12; i++) {
            insert(head, i);
        }

        printList(head);
        reverse(head);
        printList(reverse(head));
    }

    static Node reverse(Node head) {
        int length = findLength(head);
        Node temp = head;
        Node res = new Node(temp.data);
        temp = temp.next;

        for (int i = 0; i < length - 1; i++) {
            Node nn = new Node(temp.data);
            temp = temp.next;
            nn.next = res;
            res = nn;
        }

        return res;
    }

    static int findLength(Node node) {
        int res = 0;
        Node temp = node;

        while (temp != null) {
            res++;
            temp = temp.next;
        }

        return res;
    }

    static void insert(Node node, int val) {
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val);
    }

    static void printList(Node head) {
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