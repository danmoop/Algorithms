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
        Problem Statement #
        Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.

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
        int n = sc.ni();
        int[] arr = new int[n];
        arrayFillRandom(arr, n * 50); 
        int s = 612;

        println(subsetSum(arr, s));
    }   

    static boolean subsetSum(int[] arr, int s) {
        int[] cache = new int[arr.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (isFound(arr, i, 0, s, cache)) return true;
        }

        return false;
    }

    static boolean isFound(int[] arr, int i, int sum, int target, int[] cache) {
        int ss = sum + arr[i];
        if (ss == target) return true;

        if (cache[i] != -1) {
            return cache[i] == 1;
        }

        for (int j = i + 1; j < arr.length; j++) {
            boolean bool = isFound(arr, j, ss, target, cache);

            if (bool) {
                cache[i] = 1;
                return true;
            } 
        }

        cache[i] = 0;
        return false;
    }
}