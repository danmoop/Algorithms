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
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>();
        boolean[] chosen = new boolean[arr.length];
        gen(arr, list, 0, chosen);
    }

    private static void gen(int[] arr, List<Integer> list, int n, boolean[] chosen) {
        if (list.size() == arr.length) {
            println(list);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            list.add(arr[i]);
            gen(arr, list, i + 1, chosen);
            chosen[i] = false;
            list.remove(list.size() - 1);
        }
    }
}