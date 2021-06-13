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

    /*
        Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
    */

    private static void solve() {
        int[] a = {-8, -6, -5, -4, -3, -2, -1, 12, 16};
        int[] b = new int[a.length];
        int k = 0, i = 0, j = 0;

        while (a[j] < 0) j++;
        i = j - 1;

        while (j < a.length && i >= 0) {
            int right = Math.abs(a[j]);
            int left = Math.abs(a[i]);

            if (right > left) {
                b[k++] = left * left;
                i--;
            } else {
                b[k++] = right * right;
                j++;
            }
        }

        while (j < a.length) {
            b[k++] = (a[j] * a[j]);
            j++;
        }

        while (i >= 0) {
            b[k++] = (a[i] * a[i]);
            i--;
        }

        println(Arrays.toString(b));
    }
}