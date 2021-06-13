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

    private static void solve() {
        int n = sc.ni();
        int[][] mat = new int[n][n];
        int k = 1;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = k++;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                print(mat[i][j] + "\t");
            }
            ln();
        }
        ln();
            
        rotateMatrix(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                print(mat[i][j] + "\t");
            }
            ln();
        }
    }

    private static void rotateMatrix(int[][] mat) {
        int k = mat.length / 2;
        int left = 0, top = 0, right = mat.length - 1, bottom = mat.length - 1;
        int mem = -1;

        while (k-- > 0) {
           for (int i = left; i < right; i++) {
               int temp = mat[top][i];
               mat[top][i] = mem;
               mem = temp;
           }

           for (int i = top; i < bottom; i++) {
               int temp = mat[i][right];
               mat[i][right] = mem;
               mem = temp;
           }

           for (int i = right; i > left; i--) {
               int temp = mat[bottom][i];
               mat[bottom][i] = mem;
               mem = temp;
           }

           for (int i = bottom; i > top; i--) {
               int temp = mat[i][left];
               mat[i][left] = mem;
               mem = temp;
           }
           mat[top][left] = mem;
           left++;
           right--;
           top++;
           bottom--;
        }
    }
}
