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
        Permutation in a String (hard) #
        Given a string and a pattern, find out if the string contains any permutation of the pattern.

        Permutation is defined as the re-arranging of the characters of the string.
        For example, "abc" has the following six permutations:

        abc
        acb
        bac
        bca
        cab
        cba
        If a string has ‘n’ distinct characters it will have n!n! permutations.

        Example 1:
        Input: String="oidbcaf", Pattern="abc"
        Output: true
        Explanation: The string contains "bca" which is a permutation of the given pattern.

        Example 2:
        Input: String="odicf", Pattern="dc"
        Output: false
        Explanation: No permutation of the pattern is present in the given string as a substring.

        Example 3:
        Input: String="bcdxabcdy", Pattern="bcdyabcdx"
        Output: true
        Explanation: Both the string and the pattern are a permutation of each other.

        Example 4:
        Input: String="aaacb", Pattern="abc"
        Output: true
        Explanation: The string contains "acb" which is a permutation of the given pattern.
    */

    private static void solve() {
        String s = "baaaacb", pattern = "abc";
        Map<Character, Integer> map = new HashMap<>();

        for (char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, length = 0;

        while (j < s.length()) {
            char lastChar = s.charAt(j);

            if (map.containsKey(lastChar)) {
                map.put(lastChar, map.get(lastChar) - 1);

                if (map.get(lastChar) == 0) {
                    length++;
                }
            }

            if (length == map.size()) {
                println(true);
                return;
            }

            if (j - i >= pattern.length()) {
                char firstChar = s.charAt(i++);

                if(map.containsKey(firstChar)) {
                    if (map.get(firstChar) == 0) {
                        length--;
                    }
                    map.put(firstChar, map.getOrDefault(firstChar, 0) + 1);
                }
            }

            j++;
        }

        println(false);
    }
}