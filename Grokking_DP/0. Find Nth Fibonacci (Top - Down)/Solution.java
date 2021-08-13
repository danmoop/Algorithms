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

    static int[] memo;

    // Find Nth Fibonacci number (Top -> Down)
    private static void solve() {
        int n = sc.ni();
        memo = new int[n + 1];

        println(fib(n));
    }

    private static int fib(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }
}