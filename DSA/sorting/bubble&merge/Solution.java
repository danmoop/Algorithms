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

    // Bubble Sort & Merge Sort

    private static void solve() {
        int n = sc.ni();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.round(Math.random() * n);
        }

        // bubbleSort(arr);
        mergeSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    private static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            int[] first = new int[mid];
            for (int i = 0; i < mid; i++) {
                first[i] = arr[i];
            }

            int[] second = new int[arr.length - mid];
            int k = 0;
            for (int i = mid; i < arr.length; i++) {
                second[k++] = arr[i];
            }

            mergeSort(first);
            mergeSort(second);

            merge(arr, first, second);
        }
    }

    private static void merge(int[] arr, int[] first, int[] second) {
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] >= second[j]) {
                arr[k++] = second[j++];
            } else {
                arr[k++] = first[i++];
            }
        }

        while (i < first.length) {
            arr[k++] = first[i++];
        }

        while (j < second.length) {
            arr[k++] = second[j++];
        }
    }
}