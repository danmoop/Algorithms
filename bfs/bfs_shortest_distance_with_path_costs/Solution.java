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
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        int[] costs = {4, 7, 1, 7, 2, -3, -1, 1, 8};
        int[][] paths = {{0, 1}, {0, 2}, {0, 3}, {2, 5}, {3, 4}, {1, 2}, {1, 6}, {6, 7}, {6, 8}};

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i++) {
            graph.get(paths[i][0]).add(new int[] {paths[i][1], costs[i]});
        }

        for (int i = 0; i < n; i++) {
            List<int[]> p = graph.get(i);
            for(int j = 0; j < p.size(); j++) {
                println(i + ": " + Arrays.toString(p.get(j)));
            }
        }
        print("\n");

        Queue<Integer> qu = new LinkedList<>();

        qu.offer(0);

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int first = qu.poll();

                for (int j = 0; j < graph.get(first).size(); j++) {
                    int[] pair = graph.get(first).get(j);

                    int destination = pair[0];
                    int cost = pair[1];

                    distance[destination] = Math.min(distance[destination], distance[first] + cost);
                    qu.offer(destination);
                }
            }
        }
        
        for (int i = 0; i < distance.length; i++) {
            println(i + ": " + distance[i]);
        }
    }
}