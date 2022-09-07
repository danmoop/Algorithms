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
        Given an array of positive numbers, where each element represents the max number of jumps 
        that can be made forward from that element, write a program to find the minimum number of 
        jumps needed to reach the end of the array (starting from the first element). 
        If an element is 0, then we cannot move through that element.

        Example 1:

        Input = {2,1,1,1,4}
        Output = 3
        Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
        Example 2:

        Input = {1,1,3,6,9,3,0,1,3}
        Output = 4
        Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8
    */

    private static void solve() {
        int[] arr = {1, 1, 3, 6, 9, 3, 0, 1, 3};
        int[] dp = new int[arr.length];

        println(solution(arr, dp, 0));
    }

    static int solution(int[] arr, int[] dp, int i) {
        int res = (int) 1e9;

        if (i == arr.length - 1) return 0;
        if (i >= arr.length || arr[i] == 0) return res;
        if (dp[i] != 0) return dp[i];

        for (int j = 1; j <= arr[i]; j++) {
            res = Math.min(res, 1 + solution(arr, dp, i + j));
        }

        return dp[i] = res;
    }
}