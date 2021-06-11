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
        Hints:#23, #97, #130 
    */

    private static void solve() {
        String s1 = sc.ns(), s2 = sc.ns();
        int[] map = new int[26];

        String long_s, short_s;
        boolean modified = false;

        if (s1.length() >= s2.length()) {
            long_s = s1;
            short_s = s2;
        } else {
            long_s = s2;
            short_s = s1;
        }

        for (char c: long_s.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c: short_s.toCharArray()) {
            if (map[c - 'a'] == 0 && modified) {
                println(false);
                return;
            } else if (map[c - 'a'] == 0 && !modified) {
                modified = true;
            } else {
                map[c - 'a']--;
            }
        }

        println(true);
    }
}
