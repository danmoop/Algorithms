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
        Introduction
        Given an infinite supply of 'n' coin denominations and a total money amount, we are asked to find 
        the minimum number of coins needed to make up that amount.

        Example 1:

        Denominations: {1,2,3}
        Total amount: 5
        Output: 2
        Explanation: We need minimum of two coins {2,3} to make a total of '5'
        Example 2:

        Denominations: {1,2,3}
        Total amount: 11
        Output: 4
        Explanation: We need minimum four coins {2,3,3,3} to make a total of '11'

        Problem Statement
        Given a number array to represent different coin denominations and a total amount 'T', 
        we need to find the minimum number of coins needed to make change for 'T'. 
        We can assume an infinite supply of coins, therefore, each coin can be chosen multiple times.
    */

    private static void solve() {
        int[] coins = {1, 2, 3};
        int amount = 11;   

        int[][] cache = new int[coins.length + 1][amount + 1];

        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int a = (int) 1e9;

                if (j >= coins[i - 1]) {
                    a = 1 + cache[i][j - coins[i - 1]];
                }

                int b = cache[i - 1][j];
                b = b == 0 ? (int) 1e9 : b;

                cache[i][j] = Math.min(a, b);
            }
        }

        println(cache[coins.length][amount]);
    }
}