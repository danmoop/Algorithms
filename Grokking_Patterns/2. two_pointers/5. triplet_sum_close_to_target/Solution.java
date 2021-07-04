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
        Given an array of unsorted numbers and a target number, 
            find a triplet in the array whose sum is as close to the target number as possible, 
            return the sum of the triplet. 
        If there are more than one such triplet, return the sum of the triplet with the smallest sum.

        Example 1:

        Input: [-2, 0, 1, 2], target=2
        Output: 1
        Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
        Example 2:

        Input: [-3, -1, 1, 2], target=1
        Output: 0
        Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
        Example 3:

        Input: [1, 0, 1, 1], target=100
        Output: 3
        Explanation: The triplet [1, 1, 1] has the closest sum to the target.
    */

    // Target - sum = diff
    // Target - diff = sum
        
    private static void solve() {
        int[] arr = {-2, 0, 1, 2};
        int target = 2;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int low = i + 1;
            int high = arr.length - 1;

            while (low < high) {
                int sum = arr[i] + arr[low] + arr[high];

                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }

                if (sum == target) {
                    println(target - diff);
                    return;
                }

                if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        println(target - diff);
    }
}