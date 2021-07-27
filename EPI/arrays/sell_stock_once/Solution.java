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
        6.6 BUY AND SELL A STOCK ONCE
        This problem is concerned with the problem of optimally buying and selling a stock
        once, as described on Page 2. As an example, consider the following sequence of
        stock prices: (310,315, 275, 295, 260, 270, 290, 230, 255, 250). The maximum profit that
        can be made with one buy and one sell is 30—buy at 260 and sell at 290. Note that
        260 is not the lowest price, nor 290 the highest price.
    */

    private static void solve() {
        int[] arr = {310,315, 275, 295, 260, 270, 290, 230, 255, 250};
        int min = 1000;
        int profit = 0;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            profit = Math.max(profit, arr[i] - min);
        }

        println(profit);
    }
}