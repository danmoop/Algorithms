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
        Given an unsorted array of numbers, find the ‘K’ largest numbers in it.

        Example 1:
        Input: [3, 1, 5, 12, 2, 11], K = 3
        Output: [5, 12, 11]

        Example 2:
        Input: [5, 12, 11, -1, 12], K = 3
        Output: [12, 11, 12]
    */

    private static void solve() {
        int[] nums = {3, 1, 5, 12, 2, 11};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        println(pq);        
    }
}