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
        Problem Statement
        
        Given a list of non-overlapping intervals sorted by their start time, 
            insert a given interval at the correct position and merge all necessary intervals 
            to produce a list that has only mutually exclusive intervals.

        Example 1:
        Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
        Output: [[1,3], [4,7], [8,12]]
        Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

        Example 2:
        Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
        Output: [[1,3], [4,12]]
        Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].

        Example 3:
        Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
        Output: [[1,4], [5,7]]
        Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
    */

    private static void solve() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));

        println("Before: " + input);
        println("After merging: " + insert(input, new Interval(1, 4)));
    }

    private static List<Interval> insert(List<Interval> list, Interval interval) {
        List<Interval> res = new ArrayList<>();
        list.add(interval);
        Collections.sort(list, (i1, i2) -> i1.start - i2.start);

        int start = list.get(0).start;
        int end = list.get(0).end;

        for (int i = 1; i < list.size(); i++) {
            Interval in = list.get(i);

            if (in.start <= end) {
                end = Math.max(end, in.end);
            } else {
                res.add(new Interval(start, end));
                start = in.start;
                end = in.end;
            }
        }
        
        res.add(new Interval(start, end));

        return res;
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}