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
        int instances = 5;  
        int[] averageUtil = {30, 5, 4, 8, 19, 89};

        println(finalInstances(instances, averageUtil));
    }

    private static int finalInstances(int instances, int[] averageUtil) {
        int in = instances;
        int max = (int) 1e8;

        for (int i = 0; i < averageUtil.length;) {
            int step = 1, util = averageUtil[i];

            if (util < 25 && in > 1) {
                in = (int) Math.ceil(in / (2d));
                step = 10;
            } else if (util > 60 && in <= max) {
                in *= 2;
                step = 10;
            }

            i += step;
        }


        return in;
    }
}