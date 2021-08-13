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

    private static void arrayFillRandom(int[] arr, int bound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * bound);
        }
    }

    private static void shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor(Math.random() * arr.length);

            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        sc = new FastScanner();

        solve();
    }

    /*
        Problem Statement
        Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.

        Example 1:
        Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
        Output: 23
        Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
        between 5 and 15 is 23 (11+12).

        Example 2:
        Input: [3, 5, 8, 7], and K1=1, K2=4
        Output: 12
        Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest 
        number (8) is 12 (5+7).
    */

    private static void solve() {
        int[] arr = {3, 5, 8, 7};
        int k1 = 1, k2 = 4;
        int s = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }

        for (int i = 0; i < k1; i++) {
            pq.poll();
        }

        for (int i = 0; i < k2 - k1 - 1; i++) {
            s += pq.poll();
        }

        println(s);
    }
}