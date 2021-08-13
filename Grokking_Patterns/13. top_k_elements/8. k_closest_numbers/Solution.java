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
        Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest 
        numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.

        Example 1:
        Input: [5, 6, 7, 8, 9], K = 3, X = 7
        Output: [6, 7, 8]

        Example 2:
        Input: [2, 4, 5, 6, 9], K = 3, X = 6
        Output: [4, 5, 6]

        Example 3:
        Input: [2, 4, 5, 6, 9], K = 3, X = 10
        Output: [5, 6, 9]

        O((m+k)logK), m = arr.length - k
    */

    private static void solve() {
        int[] arr = {2, 4, 5, 6, 9};
        int k = 3, x = 6;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(b - x) - Math.abs(a - x));

        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < Math.abs(pq.peek() - x)) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        Arrays.sort(res);
        println(Arrays.toString(res));
    }
}