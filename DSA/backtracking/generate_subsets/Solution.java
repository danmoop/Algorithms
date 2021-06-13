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

    private static void solve() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();

        gen(arr, list, 0);
    }

    private static void gen(int[] arr, List<Integer> list, int n) {
        if (n == arr.length) {
            println(list);
            return;
        }

        for (int i = n; i < arr.length; i++) {
            list.add(arr[i]);
            gen(arr, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}