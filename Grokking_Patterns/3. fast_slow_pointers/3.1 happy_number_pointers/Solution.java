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
        Problem Statement #
        Any number will be called a happy number if, after repeatedly replacing it with a 
            number equal to the sum of the square of all of its digits, leads us to number ‘1’. 
        All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

        Example 1:

        Input: 23   
        Output: true (23 is a happy number)  
        Explanations: Here are the steps to find out that 23 is a happy number:
        2^2 + 3^2 = 4 + 9 = 13
        1^2 + 3^2 = 1 + 9 = 10
        1^2 + 0^2 = 1

        Example 2:
        Input: 12   
        Output: false (12 is not a happy number)  
    */

    private static void solve() {
        int n = sc.ni();

        println(isHappyNumber(n));
    }

    private static boolean isHappyNumber(int n) {
        int slow = n, fast = n;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int findSquareSum(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n /= 10;
        }

        return sum;
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