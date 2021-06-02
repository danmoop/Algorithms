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
        int n = 9;
        List<List<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] paths = {{0, 1}, {0, 2}, {0, 3}, {2, 5}, {3, 4}, {1, 2}, {1, 6}, {6, 7}, {6, 8}};

        for (int i = 0; i < paths.length; i++) {
            graph.get(paths[i][0]).add(paths[i][1]);
        }

        for (int i = 0; i < n; i++) {
            println(i + ": " + graph.get(i));
        }
        print("\n");

        Queue<Integer> qu = new LinkedList<>();

        qu.offer(0);

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int first = qu.poll();

                for (int j = 0; j < graph.get(first).size(); j++) {
                    int adj = graph.get(first).get(j);
                    distance[adj] = Math.min(distance[adj], distance[first] + 1);
                    qu.offer(adj);
                }
            }
        }
        
        for (int i = 0; i < distance.length; i++) {
            println(i + ": " + distance[i]);
        }
    }
}