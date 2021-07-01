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

    // Find if heap meets a max-heap property or not
    private static void solve() {
        int[] arr = {10, 9, 6, 8, 5, 3, 1, 7, 4, 2};
        println(isMaxHeap(arr, 0));
    }

    private static boolean isMaxHeap(int[] arr, int index) {
        if (index >= arr.length) return true;

        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < arr.length && arr[index] < arr[left]) return false;
        if (right < arr.length && arr[index] < arr[right]) return false;

        return isMaxHeap(arr, left) && isMaxHeap(arr, right);
    }
}