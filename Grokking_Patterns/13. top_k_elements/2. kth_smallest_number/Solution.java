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
            return sc.nextInt();
        }

        public String ns() {
            return sc.nextLine();
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
        Given an unsorted array of numbers, find Kth smallest number in it.
        Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.

        Example 1:
        Input: [1, 5, 12, 2, 11, 5], K = 3
        Output: 5
        Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].

        Example 2:
        Input: [1, 5, 12, 2, 11, 5], K = 4
        Output: 5
        Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].

        Example 3:
        Input: [5, 12, 11, -1, 12], K = 3
        Output: 11
        Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
    */

    private static void solve() {
        int[] arr = {1, 5, 12, 2, 11, 5};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        println(pq.peek());
    }
}