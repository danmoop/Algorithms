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
        Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

        Example 1:

        Input: [-1, 0, 2, 3], target=3 
        Output: 2
        Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
        Example 2:

        Input: [-1, 4, 2, 1, 3], target=5 
        Output: 4
        Explanation: There are four triplets whose sum is less than the target: 
        [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
    */
    
    private static void solve() {
        int[] arr = {-1, 4, 2, 1, 3};
        Arrays.sort(arr); // -1, 1, 2, 3, 4
        int target = 5, count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int high = arr.length - 1;
    
                while (high > j) {
                    int sum = arr[i] + arr[j] + arr[high];

                    if (sum < target) {
                        count++;
                    }
                    high--;
                }
            }
        }

        println(count);
    }
}