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
        6.18 ROTATE A 2D ARRAY
        Image rotation isa fundamental operation in computer graphics. Figure 6.4 illustrates
        the rotation operation on a 2D array representing a bit-map of an image. Specifically,
        the image isrotated by 90 degrees clockwise.
        Write a function that takes as input an n X n 2D array, and rotates the array by
        90 degrees clockwise
    */

    private static void solve() {
        int n = sc.ni(), c = 0;
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ++c;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            int j = 0, k = n - 1;

            while (j < k) {
                int t = grid[i][j];
                grid[i][j] = grid[i][k];
                grid[i][k] = t;
                j++;
                k--;
            }
        }

        for (int i = 0; i < n; i++) {
            println(Arrays.toString(grid[i]));
        }
    }
}