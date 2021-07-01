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
        int[] arr = {2, 1, 7, 5, 3, 9, 10};

        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i);
        }

        println(Arrays.toString(arr));
    }

    private static void maxHeapify(int[] arr, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest;

        if (left < arr.length && arr[left] > arr[index]) {
            largest = left;
        } else {
            largest = index;
        }

        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (index != largest) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, largest);
        }
    }
}