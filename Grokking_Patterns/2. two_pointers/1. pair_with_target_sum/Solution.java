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
        Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

        Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

        Example 1:
        Input: [1, 2, 3, 4, 6], target=6
        Output: [1, 3]
        Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

        Example 2:
        Input: [2, 5, 9, 11], target=11
        Output: [0, 2]
        Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
    */

    private static void solve() {
        int[] array = {2, 5, 9, 11};
        int target = 11;

        int i = 0, j = array.length - 1;

        while(i < j) {
            if (array[i] + array[j] == target) {
                println(Arrays.toString(new int[] {i, j}));
                return;
            } else if (array[i] + array[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        println(Arrays.toString(new int[] {-1, -1}));
    }
}