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
            return Integer.parseInt(ns());
        }

        public String ns() {
            return sc.next();
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

    /*
        You are given a matrix nxm filled with integers. There is a robot which has to travel from the cell (1,1) 
        to cell (n,n) and the robot can move only one cell to the right or downwards. The robot requires strength to 
        travel from one cell to another. He can only move forward if his strength is positive. When he moves to a cell, 
        the cell value is added to his strength(value can be negative or positive). Calculate the minimum strength you have 
        to give to the robot initially so that he can make it to the last cell.
    */

    private static void solve() {
        int n = 8;
        int[][] grid = new int[n][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = (int) Math.round(Math.random() * 55);
            }
        }
        grid[0][0] = 0;

        int[][] gridCopy = new int[grid.length][grid.length];
        int maxStrength = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                gridCopy[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            println(Arrays.toString(grid[i]));
        }

        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
            grid[0][i] += grid[0][i-1];
        }  

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        print("\n");

        for (int i = 0; i < grid.length; i++) {
            println(Arrays.toString(grid[i]));
        }

        int i = 0, j = 0;

        while (i < grid.length - 1 && j < grid.length - 1) {
            maxStrength = Math.max(maxStrength, gridCopy[i][j]);
            if (grid[i][j+1] > grid[i+1][j]) {
                i++;
            } else {
                j++;
            }
        }

        while (i < grid.length - 1) {
            maxStrength = Math.max(maxStrength, gridCopy[i++][j]);
        }

        while (j < grid.length) {
            maxStrength = Math.max(maxStrength, gridCopy[i][j]);
            j++;
        }

        println("\nMin strength: " + maxStrength);
    }
}