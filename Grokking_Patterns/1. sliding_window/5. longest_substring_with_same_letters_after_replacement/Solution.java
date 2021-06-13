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
        Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

        Example 1:
        Input: String="aabccbb", k=2
        Output: 5
        Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".

        Example 2:
        Input: String="abbcb", k=1
        Output: 4
        Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".

        Example 3:
        Input: String="abccde", k=1
        Output: 3
        Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
    */

    private static void solve() {
        String s = "abccde";
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, k = 1, maxLength = 0, res = 0;
        
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            maxLength = Math.max(maxLength, map.get(s.charAt(j++)));

            if (j - i - maxLength > k) {
                if (map.get(s.charAt(i)) == maxLength) {
                    maxLength--;
                }

                map.put(s.charAt(i), map.get(s.charAt(i++)) - 1);
            }

            res = Math.max(res, j - i);
        }

        println(res);
    }
}