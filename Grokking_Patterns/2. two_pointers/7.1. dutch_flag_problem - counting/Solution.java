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
    Problem Statement #
    Given an array containing 0s, 1s and 2s, sort the array in-place. 
    You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

    The flag of the Netherlands consists of three colors: 
        red, white and blue; and since our input array also consists of three different numbers 
        that is why it is called Dutch National Flag problem.

    Example 1:

    Input: [1, 0, 2, 1, 0]
    Output: [0 0 1 1 2]
    Example 2:

    Input: [2, 2, 0, 1, 2, 0]
    Output: [0 0 1 2 2 2 ]
    */
    
    private static void solve() {
        int[] arr = {2, 2, 2, 2, 0, 1, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 1, 0};
        int ones = 0, twos = 0;

        for (int i: arr) {
            if (i == 1) ones++;
            else if (i == 2) twos++;
        }
        int k = arr.length - 1;

        while (twos-- > 0) {
            arr[k--] = 2;
        }

        while (ones-- > 0) {
            arr[k--] = 1;
        }

        while (k >= 0) {
            arr[k--] = 0;
        }

        println(Arrays.toString(arr));
    }
}