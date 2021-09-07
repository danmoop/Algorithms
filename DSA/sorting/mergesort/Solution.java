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
        int n = sc.ni();
        int[] arr = new int[n];
        arrayFillRandom(arr, n * 10);

        println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] L = new int[mid - left + 1];
        int[] R = new int[right - mid];

        for (int i = 0; i < L.length; i++) {
            L[i] = arr[left + i];
        }

        for (int i = 0; i < R.length; i++) {
            R[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0, k = 0;

        while (i < L.length && j < R.length) {
            if (L[i] >= R[j]) {
                arr[k + left] = R[j++]; k++;
            } else {
                arr[k + left] = L[i++]; k++;
            }
        }

        while (i < L.length) {
            arr[k + left] = L[i++]; k++;
        }

        while (j < R.length) {
            arr[k + left] = R[j++]; k++;
        }
    }
}