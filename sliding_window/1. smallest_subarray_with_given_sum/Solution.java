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
        Given an array of positive numbers and a positive number ‘S’, 
        find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 

        Input: [2, 1, 5, 2, 3, 2], S=7 
        Output: 2
        Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
    */

    private static void solve() {
        int[] a = {2, 1, 5, 2, 8};
        int i = 0, j = 0, k = 7, s = 0, res = Integer.MAX_VALUE;

        while(j < a.length) {
            s += a[j++];

            while(s >= k) {
                res = Math.min(res, j - i);
                s -= a[i++];
            }
        }

        println(res == Integer.MAX_VALUE ? -1 : res);
    }
}