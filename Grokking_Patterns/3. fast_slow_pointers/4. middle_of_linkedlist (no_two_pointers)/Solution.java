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

    /*
        Problem Statement
        Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.

        If the total number of nodes in the LinkedList is even, return the second middle node.

        Example 1:
        Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Output: 3

        Example 2:
        Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        Output: 4

        Example 3:
        Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
        Output: 4
    */

    private static void solve() {
        Node head = new Node(1);
        for (int i = 2; i <= 7; i++) {
            insert(head, i);
        }

        printList(head);
        println(middle(head));
    }

    static int middle(Node head) {
        Node temp = head;
        int middle = listLength(head) / 2;
        int index = 0;

        while (index != middle) {
            index++;
            temp = temp.next;
        }

        return temp.data;
    }

    static int listLength(Node head) {
        int res = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            res++;
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