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

    // Find Nth Fibonacci number (Bottom -> Up)
    private static void solve() {
        int n = sc.ni();

        println(fib(n));
    }

    private static int fib(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] += (memo[i - 1] + memo[i - 2]);
        }

        return memo[n];
    }
}