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

    // Floyd-Warshall
    private static void solve() {
        int n = sc.ni();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = rand(n * 3);
            }
        }

        for (int i = 0; i < n; i++) {
            println(Arrays.toString(arr[i]));
        }

        print("\n");

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int weight = arr[i][k] + arr[k][j];
                    if (weight < arr[i][j]) {
                        arr[i][j] = weight;
                        println(i + " -> " + j + " ==> " + i + " -> " + k + " -> " + j);
                    }
                }
            }
        }

        print("\n");

        for (int i = 0; i < n; i++) {
            println(Arrays.toString(arr[i]));
        }
    }

    static int rand(int bound) {
        return (int) Math.round(Math.random() * bound);
    }
}