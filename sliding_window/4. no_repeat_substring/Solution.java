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
        Given a string, find the length of the longest substring which has no repeating characters.

        Example 1:

        Input: String="aabccbb"
        Output: 3
        Explanation: The longest substring without any repeating characters is "abc".
        Example 2:

        Input: String="abbbb"
        Output: 2
        Explanation: The longest substring without any repeating characters is "ab".
        Example 3:

        Input: String="abccde"
        Output: 3
        Explanation: Longest substrings without any repeating characters are "abc" & "cde".
    */

    private static void solve() {
        String s = "abccde";
        int i = 0, j = 0, res = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if(set.contains(s.charAt(j))) {
                res = Math.max(res, j - i);
                i = j;
                set.clear();
            }

            set.add(s.charAt(j++));
        }

        println(res);
    }
}