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
        String Anagrams (hard) #
        Given a string and a pattern, find all anagrams of the pattern in the given string.

        Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:

        abc
        acb
        bac
        bca
        cab
        cba
        Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

        Example 1:
        Input: String="ppqp", Pattern="pq"
        Output: [1, 2]
        Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

        Example 2:
        Input: String="abbcabc", Pattern="abc"
        Output: [2, 3, 4]
        Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
    */

    private static void solve() {
        String s = "abbcabc", p = "abc";
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int i = 0, j = 0, length = 0;
        while (j < s.length()) {
            char lastChar = s.charAt(j++);

            if (map.containsKey(lastChar)) {
                map.put(lastChar, map.get(lastChar) - 1);

                if (map.get(lastChar) == 0) {
                    length++;
                }
            }

            if (length == p.length()) {
                list.add(i);
            }

            if (j - i >= p.length()) {
                char firstChar = s.charAt(i++);

                if (map.containsKey(firstChar)) {
                    if (map.get(firstChar) == 0) {
                        length--;
                    }

                    map.put(firstChar, map.get(firstChar) + 1);
                }
            }
        }

        println(list);
    }
}