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

    private static void arrayFillRandom(int[] arr, int bound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * bound);
        }
    }

    private static void shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor(Math.random() * arr.length);

            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        sc = new FastScanner();

        solve();
    }

    /*
        Problem Statement
        Given a string, sort it based on the decreasing frequency of its characters.

        Example 1:
        Input: "Programming"
        Output: "rrggmmPiano"
        Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.

        Example 2:
        Input: "abcbab"
        Output: "bbbaac"
        Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.
    */

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        String s = sc.ns();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        println(sb.toString());
    }
}