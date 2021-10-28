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

    private static void solve() {
        String m = "abcedffdghhhg";
        String n = "bedffhg";
        int[][] cache = new int[m.length()+1][n.length()+1];
        
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }
        
        println(LCS(m, n, m.length() - 1, n.length() - 1, cache));
    }
    
    static int LCS(String m, String n, int ms, int ns, int[][] cache) {
        if (ms < 0 || ns < 0) return 0;

        if (cache[ms][ns] != -1) {
            return cache[ms][ns];
        }

        if (m.charAt(ms) == n.charAt(ns)) {
            return cache[ms][ns] = 1 + LCS(m, n, ms - 1, ns - 1,cache);
        }

        return cache[ms][ns] = Math.max(LCS(m, n, ms - 1, ns,cache), LCS(m, n, ms, ns - 1,cache));
    }
}