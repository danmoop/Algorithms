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
        6.19 COMPUTE ROWS IN PASCAL'S TRIANGLE
        Figure 6.5 shows the first five rows of a graphic that is known as Pascal's triangle.
        Each row contains one more entry than the previous one. Exceptfor entriesin the last
        row, each entry is adjacent to one or two numbersin the row below it. The first row
        holds 1. Each entry holds the sum of the numbersin the adjacent entries above it.
        Write a program which takes asinput a nonnegative integer n and returns the first n
        rows of Pascal's triangle

                  [1]
                [1, 1]
              [1, 2, 1]
            [1, 3, 3, 1]
           [1, 4, 6, 4, 1]
         [1, 5, 10, 10, 5, 1]
        [1, 6, 15, 20, 15, 6, 1]
    */
    private static void solve() {
        int n = sc.ni();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(1, 1));

        for (int i = 0; i < n - 2; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = triangle.get(triangle.size() - 1);

            list.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                list.add(prev.get(j) + prev.get(j + 1));
            }
            list.add(1);
            triangle.add(list);
        }

        for (List<Integer> list: triangle) {
            println(list);
        }
    }
}