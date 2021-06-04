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
        Problem Statement
        Given an array of sorted numbers, remove all duplicates from it. 
        You should not use any extra space; 
        after removing the duplicates in-place return the new length of the array.
    */

    private static void solve() {
        int[] a = {2, 2, 2, 2, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8, 8, 8, 10, 12, 14, 14, 14};
        int c = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i-1]) c++;
        }

        println(a.length - c);
    }
}