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

    private static void solve() {
        int n = sc.ni();

        int[] a = new int[n];

        for(int k = 0; k < n; k++) {
            a[k] = (int) Math.round(Math.random());
        }
        println("Before: " + Arrays.toString(a));

        int i = 0, j = a.length - 1;

        while(i < j) {
            while(i < j && a[i] == 1) i++;
            while(i < j && a[j] == 0) j--;

            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        println("After: " + Arrays.toString(a));
    }
}