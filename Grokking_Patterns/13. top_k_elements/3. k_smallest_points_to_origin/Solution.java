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
        Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.

        Example 1:
        Input: points = [[1,2],[1,3]], K = 1
        Output: [[1,2]]
        Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
        The Euclidean distance between (1, 3) and the origin is sqrt(10).
        Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.

        Example 2:
        Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
        Output: [[1, 3], [2, -1]]
    */

    private static void solve() {
        int[][] arr = {{3, 4}, {1, 3}, {2, -1}};
        int k = 2;
        PriorityQueue<int[]> pq = new PriorityQueue((a, b) -> getDist((int[]) b) - getDist((int[]) a));

        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (getDist(arr[i]) < getDist(pq.peek())) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            println(Arrays.toString(pq.poll()));
        }
    }

    private static int getDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}