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

    private static void solve() {
        List<List<Integer>> graph = new ArrayList<>();
        int n = 7;
        boolean[] vis = new boolean[n];
        boolean[] rec = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] paths = {{0, 2}, {2, 1}, {2, 3}, {1, 6}, {3, 4}, {6, 4}, {3, 5}, {4, 5}};

        for (int[] path: paths) {
            graph.get(path[0]).add(path[1]);
        }

        for (int i = 0; i < n; i++) {
            println(i + ": " + graph.get(i));
        }

        println(isCycled(graph, rec, vis, 0));
    }

    private static boolean isCycled(List<List<Integer>> graph, boolean[] rec, boolean[] vis, int node) {
        if (rec[node]) return true;
        if (vis[node]) return false;
        rec[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            int adj = graph.get(node).get(i);
            if (isCycled(graph, rec, vis, adj)) return true;
        }

        rec[node] = false;
        return false;
    }
}