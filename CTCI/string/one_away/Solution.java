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
        One Away: There are three types of edits that can be performed on strings: insert a character,
        remove a character, or replace a character. Given two strings, write a function to check if they are
        one edit (or zero edits) away.
        EXAMPLE
        pale, ple -> true
        pales, pale -> true
        pale, bale -> true
        pale, bake -> false
    */

    private static void solve() {
        String str1 = sc.ns(), str2 = sc.ns();

        if (Math.abs(str1.length() - str2.length()) > 1) {
            println(false);
            return;
        }

        String s1 = str1.length() >= str2.length() ? str1 : str2;
        String s2 = str2.length() > str1.length() ? str1 : str2;
        int i = 0, j = 0;
        boolean modified = false;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (modified) {
                    println(false);
                    return;
                }
                modified = true;

                if (s1.length() == s2.length()) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            } else {
                i++;
                j++;
            }
        }
        
        println(true);
    }
}