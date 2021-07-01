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

    // Insertion sort
    private static void solve() {
        int n = sc.ni();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.floor(Math.random() * 25);
        }
        
        println("Before sorting: " + Arrays.toString(arr));

        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > cur) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = cur;
        }

        println("After sorting: " + Arrays.toString(arr));
    }
}