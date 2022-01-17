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

    // Sudoku solver using backtracking

    private static void solve() {
        int[][] grid = new int[][] {
            {0,4,7,0,0,3,0,2,0},
            {0,0,0,0,6,0,0,0,5},
            {1,0,0,0,0,0,0,0,0},
            {2,0,0,0,0,1,0,0,0},
            {8,0,0,0,0,0,0,9,0},
            {0,9,1,0,3,0,6,0,0},
            {0,8,0,0,0,0,0,0,0},
            {0,0,0,4,0,0,2,0,0},
            {0,3,9,0,0,7,0,4,0},
        };

        display(grid); 
        ln();

        int[][] mat = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        backtrack(grid, 0, 0);
    }

    static void backtrack(int[][] grid, int i, int j) {
        if (j == 9) {
            i++; j = 0;
        }

        if (j == 0 && i == 9) {
            display(grid);
            ln();
            return;
        }

        if (grid[i][j] != 0) {
            backtrack(grid, i, j + 1);
        } else {
            for (int k = 1; k <= 9; k++) {
                grid[i][j] = k;
                if (isValid(grid, i, j)) {
                    backtrack(grid, i, j + 1);
                }
                grid[i][j] = 0;
            }   
        }
    }

    static boolean isValid(int[][] grid, int i, int j) {
        Set<Integer> set = new HashSet<>();
        
        for (int k = 0; k < grid.length; k++) {
            if (k == j) continue;
            set.add(grid[i][k]);
        }

        if (set.contains(grid[i][j])) return false;

        set.clear();

        for (int k = 0; k < grid.length; k++) {
            if (k == i) continue;
            set.add(grid[k][j]);
        }

        if (set.contains(grid[i][j])) return false;

        for (int a = 0; a < 9; a += 3) {
            for (int b = 0; b < 9; b += 3) {
                Map<Integer, Integer> map = new HashMap<>();
        
                for (int m = 0 + a; m < 3 + a; m++) {
                    for (int n = 0 + b; n < 3 + b; n++) {
                        if (grid[m][n] != 0) {
                            map.put(grid[m][n], map.getOrDefault(grid[m][n], 0) + 1);
                        }
                    }
                }        

                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    if (entry.getValue() > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static void display(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            println(Arrays.toString(grid[i]));
        }
    }
}