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
        Introduction #
        Given the weights and profits of 'N' items, we are asked to put these items in a knapsack which has a capacity 'C'. 
        The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as 
        we don’t have multiple quantities of any item.

        Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

        Items: { Apple, Orange, Banana, Melon }
        Weights: { 2, 3, 1, 4 }
        Profits: { 4, 5, 3, 7 }
        Knapsack capacity: 5

        Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:

        Apple + Orange (total weight 5) => 9 profit
        Apple + Banana (total weight 3) => 7 profit
        Orange + Banana (total weight 4) => 8 profit
        Banana + Melon (total weight 5) => 10 profit

        This shows that Banana + Melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.

        Problem Statement #
        Given two integer arrays to represent weights and profits of 'N' items, we need to find a subset of these items which will 
        give us maximum profit such that their cumulative weight is not more than a given number 'C'. 
        Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
    */

    private static void solve() {
        int[] profit = {1, 6, 10, 16};
        int[] weight = {1, 2, 3, 5};
        int capacity = 7;

        int[][] cache = new int[profit.length + 1][capacity + 1];

        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int p1 = 0;

                if (j >= weight[i - 1]) {
                    p1 = profit[i - 1] + cache[i - 1][j - weight[i - 1]];
                }

                int p2 = cache[i - 1][j];

                cache[i][j] = Math.max(p1, p2);
            }
        }

        println(cache[profit.length][capacity]);
    }
}