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

    // You can make 1, 2, or 3 steps to complete the entire path. Find the lowest price you pay to complete the path

    private static void solve() {
        int n = 16;
        int[] cost = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = (int) Math.round(Math.random() * 100 - 20);
        }

        dp[0] = cost[0];
        dp[1] = Math.min(cost[1], cost[1] + dp[0]);
        dp[2] = Math.min(cost[2], cost[2] + Math.min(dp[0], dp[1]));

        for (int i = 3; i < n; i++) {
            dp[i] += Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3])) + cost[i];
        }

        println("Prices: " + Arrays.toString(cost));

        println("\nPrice you pay: " + Math.min(dp[n-1], Math.min(dp[n-2], dp[n-3])));
    }
}