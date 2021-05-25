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
        int[][] board = new int[n][n];
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[n*2];
        boolean[] diag2 = new boolean[n*2];

        dfs(board, rows, cols, diag, diag2, 0);
        println(c);
    }

    private static void dfs(int[][] board, boolean[] rows, boolean[] cols, boolean[] diag, boolean[] diag2, int row) {
        if(row == board.length) {
            c++;
            return;
        }

        for(int col = 0; col < board[row].length; col++) {
            if(rows[row] || cols[col] || board[row][col] == 1 || diag[row+col] || diag2[row-col+board.length-1]) continue;

            board[row][col] = 1;
            rows[row] = cols[col] = diag[row+col] = diag2[row-col+board.length-1] = true;

            dfs(board, rows, cols, diag, diag2, row + 1);

            rows[row] = cols[col] = diag[row+col] = diag2[row-col+board.length-1] = false;
            board[row][col] = 0;
        }
    }
}