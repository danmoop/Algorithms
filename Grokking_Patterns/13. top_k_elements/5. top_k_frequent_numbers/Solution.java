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
        Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.

        Example 1:
        Input: [1, 3, 5, 12, 11, 12, 11], K = 2
        Output: [12, 11]
        Explanation: Both '11' and '12' apeared twice.

        Example 2:
        Input: [5, 12, 11, 3, 11], K = 2
        Output: [11, 5] or [11, 12] or [11, 3]
        Explanation: Only '11' appeared twice, all other numbers appeared once.
    */

    private static void solve() {
        int[] arr = {1, 3, 5, 12, 11, 12, 11};
        int k = 2;

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            int num = pq.poll();
            if (set.contains(num)) i--;
            set.add(num);
        }

        println(set);
    }
}