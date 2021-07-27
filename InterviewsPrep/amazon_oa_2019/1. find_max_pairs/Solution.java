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

    /*  This problem is from Amazon 2019 OA's, I found it on LeetCode discussions page

        Given 2 lists a and b. Each element is a pair of integers where the first 
            integer represents the unique id and the second integer represents a value. 
        
        Your task is to find an element from a and an element form b such that the sum
            of their values is less or equal to target and as close to target as possible. 
        
        Return a list of ids of selected elements. If no pair is possible, return an empty list.
    */

    private static void solve() {
        int[][] a = {{1, 8}, {2, 15}, {3, 9}};
        int[][] b = {{1, 8}, {2, 11}, {3, 12}};
        int target = 20, max = 0;

        List<int[]> res = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = 0;
                sum += a[i][1];
                sum += b[j][1];

                if (sum >= max && sum <= target) {
                    max = sum;

                    List<List<Integer>> list = map.getOrDefault(max, new ArrayList<>());
                    list.add(Arrays.asList(a[i][0], b[j][0]));
                    map.put(max, list);
                }
            }
        }

        println(map.getOrDefault(max, new ArrayList<>()));
    }
}