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
        Problem Statement #
        Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
    */
        
    private static void solve() {
        int[] arr = {-5, 2, -1, -2, 3};
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            addTriplets(arr, i + 1, set, -arr[i]);
        }

        println(set);
    }

    private static void addTriplets(int[] arr, int i, Set<List<Integer>> set, int target) {
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == target) {
                set.add(Arrays.asList(-target, arr[i], arr[j]));
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}