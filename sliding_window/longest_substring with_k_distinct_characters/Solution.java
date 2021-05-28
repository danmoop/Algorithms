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
        Given a string, find the length of the longest substring in it with no more than K distinct characters.

        Example 1:

        Input: String="araaci", K=2
        Output: 4
        Explanation: The longest substring with no more than '2' distinct characters is "araa".
        Example 2:

        Input: String="araaci", K=1
        Output: 2
        Explanation: The longest substring with no more than '1' distinct characters is "aa".
        Example 3:

        Input: String="cbbebi", K=3
        Output: 5
        Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
    */

    private static void solve() {
        String s = "araaci";
        int i = 0, j = 0, k = 1, res = 0;
        Set<Character> set = new HashSet<>();

        while(j < s.length()) {
            set.add(s.charAt(j++));

            while(set.size() > k) {
                set.remove(s.charAt(i++));
                res = Math.max(res, j - i);
            }
        }

        println(res);
    }
}