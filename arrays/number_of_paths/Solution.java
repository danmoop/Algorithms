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

    static int c = 0;

    private static void solve() {
        int n = sc.ni();
        long[][] mat = new long[n][n];

        dfs(mat, 0, 0);
        dp(mat);
        println("recursion: " + c);
    }

    private static void dp(long[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][0] = 1;
        }

        for (int j = 1; j < mat.length; j++) {
            for (int i = j; i < mat.length; i++) {
                mat[i][j] += (mat[i-1][j] + mat[i][j-1]);
            }
        }

        println("dp: " + mat[mat.length-1][mat.length-1]);
    }

    private static void dfs(long[][] mat, int i, int j) {
        if (i >= mat.length || j >= mat.length || i < j) {
            return;
        }

        if (i == mat.length - 1 && j == mat.length - 1) {
            c++;
            return;
        }

        dfs(mat, i + 1, j);
        dfs(mat, i, j + 1);
    }
}