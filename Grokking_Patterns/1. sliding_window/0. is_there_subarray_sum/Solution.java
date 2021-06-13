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

    // Find a subarray whose sum is x or report that there is no such subarray.

    private static void solve() {
        int[] arr = {1, 3, 2, 5, 1, 1, 2, 3};
        int i = 0, j = 0, sum = 0, x = 8;

        while (j < arr.length) {
            sum += arr[j++];

            if (sum == x) {
                println(true);
                return;
            }

            while (sum > x) {
                sum -= arr[i++];
            }
        }

        println(false);
    }
}