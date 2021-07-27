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

    /*
        6.5 DELETE DUPLICATES FROM A SORTED ARRAY
        This problem is concerned with deleting repeated elements from a sorted array.
        For example, for the array (2,3,5,5,7,11,11,11,13), then after deletion, the array is
        (2,3,5,7,11,13,0,0,0). After deleting repeated elements, there are 6 valid entries.
        There are no requirements as to the valuesstored beyond the last valid element.
    */
        
    private static void solve() {
        List<Integer> A = Arrays.asList(2,3,5,5,7,11,11,11,13);
        println(A);
        delete(A);
    }

    static void delete(List<Integer> A) {
        int k = 1;

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) != A.get(i - 1)) {
                A.set(k, A.get(i));
                k++;
            }
        }

        while (k < A.size()) {
            A.set(k, 0);
            k++;
        }
        println(A);
    }
}