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
        Given a rod of length 'n', we are asked to cut the rod and sell the pieces in a way that will maximize the profit. 
        We are also given the price of every piece of length 'i' where 1 <= i <= n.

        Example:

        Lengths: [1, 2, 3, 4, 5]
        Prices: [2, 6, 7, 10, 13]
        Rod Length: 5

        Let’s try different combinations of cutting the rod:

        Five pieces of length 1 => 10 price
        Two pieces of length 2 and one piece of length 1 => 14 price
        One piece of length 3 and two pieces of length 1 => 11 price
        One piece of length 3 and one piece of length 2 => 13 price
        One piece of length 4 and one piece of length 1 => 12 price
        One piece of length 5 => 13 price

        This shows that we get the maximum price (14) by cutting the rod into two pieces of length '2' and one piece of length '1'.
    */

    private static void solve() {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        
        int length = 52;
        int[] cache = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (i >= lengths[j]) {
                    cache[i] = Math.max(cache[i], prices[j] + cache[i - lengths[j]]);
                }
            }
        }

        println(cache[length]);
    }
}