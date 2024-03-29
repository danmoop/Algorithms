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
        Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number 'S'

        Example 1: #
        Input: {1, 2, 3, 7}, S=6
        Output: True
        The given set has a subset whose sum is '6': {1, 2, 3}

        Example 2: #
        Input: {1, 2, 7, 1, 5}, S=10
        Output: True
        The given set has a subset whose sum is '10': {1, 2, 7}

        Example 3: #
        Input: {1, 3, 4, 8}, S=6
        Output: False
        The given set does not have any subset whose sum is equal to '6'.
    */

    private static void solve() {
        int[] arr = {1, 2, 7, 1, 5};
        int s = 10;
        boolean[][] cache = new boolean[arr.length][s + 1];

        println(subset(cache, arr, s, 0));
    }

    static boolean subset(boolean[][] cache, int[] arr, int s, int i) {
        if (i >= arr.length) return false;
        if (s == 0) return true;

        if (cache[i][s]) return true;

        if (s >= arr[i] && subset(cache, arr, s - arr[i], i + 1)) return cache[i][s] = true;
        return cache[i][s] = subset(cache, arr, s, i + 1); 
    }
}