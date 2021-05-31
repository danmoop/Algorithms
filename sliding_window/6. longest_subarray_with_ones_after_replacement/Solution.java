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
        Problem Statement #
        Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
        find the length of the longest contiguous subarray having all 1s.

        Example 1:
        Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        Output: 6
        Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

        Example 2:
        Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
        Output: 9
        Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
    */

    private static void solve() {
        int[] array = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int i = 0, j = 0, k = 3, ones = 0, res = 0;

        while (j < array.length) {
            if (array[j] == 1) ones++;

            if (j - i + 1 - ones > k) {
                if(array[i] == 1) ones--;
                i++;
            }

            j++;
            res = Math.max(j - i, res);
        }

        println(res);
    }
}