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
        6.17 COMPUTE THE SPIRAL ORDERING OF A 2D ARRAY
        A 2D array can be written as a sequence in several orders—the most natural ones
        being row-by-row or column-by-column. In this problem we explore the problem
        of writing the 2D array in spiral order. For example, the spiral ordering for the 2D
        array in Figure 6.3(a) is (1,2,3,6,9,8,7,4,5). For Figure 6.3(b), the spiral ordering is
        <1, 2,3, 4,8,12,16,15,14,13,9,5, 6, 7,11,10)
    */

    private static void solve() {
        int n = sc.ni();
        int[][] grid = new int[n][n];
        int[] res = new int[n * n];
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ++c;
            }
        }

        for (int i = 0; i < n; i++) {
            println(Arrays.toString(grid[i]));
        }

        int k = 0;

        int left = 0, right = grid.length - 1, top = 0, bottom = grid.length - 1;

        while (top <= bottom) {
            // top -> left to right

            for (int i = left; i <= right; i++) {
                res[k++] = grid[top][i];
            }
            top++;

            // right -> top to bottom
            for (int i = top; i <= bottom; i++) {
                res[k++] = grid[i][right];
            }
            right--;

            // bottom -> right to left
            for (int i = right; i >= left; i--) {
                res[k++] = grid[bottom][i];
            }
            bottom--;

            // left -> bottom to top
            for (int i = bottom; i >= top; i--) {
                res[k++] = grid[i][left];
            }
            left++;
        }

        println("\n" + Arrays.toString(res));
    }
}