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

    // Heapsort
    private static void solve() {
        int n = sc.ni();
        int[] arr = new int[n];
        arrayFillRandom(arr, 100);

        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, 0, i);
        }

        println(Arrays.toString(arr));
    }

    private static void maxHeapify(int[] arr, int index, int length) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest;

        if (left < length && arr[left] > arr[index]) {
            largest = left;
        } else {
            largest = index;
        }

        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (index != largest) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, length);
        }
    }
}