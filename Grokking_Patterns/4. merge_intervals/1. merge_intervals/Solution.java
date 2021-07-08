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
        Problem Statement #
        Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

        Example 1:
        Intervals: [[1,4], [2,5], [7,9]]
        Output: [[1,5], [7,9]]
        Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into 
        one [1,5].

        Example 2:
        Intervals: [[6,7], [2,4], [5,9]]
        Output: [[2,4], [5,9]]
        Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
         
        Example 3:
        Intervals: [[1,4], [2,6], [3,5]]
        Output: [[1,6]]
        Explanation: Since all the given intervals overlap, we merged them into one.
    */

    private static void solve() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        input.add(new Interval(7, 8));

        println("Not merged: " + input);
        println("Merged: " + merge(input));
    }

    private static List<Interval> merge(List<Interval> input) {
        if (input.size() < 2) {
            return input;
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        Collections.sort(input, (l1, l2) -> l1.start - l2.start);

        int start = input.get(0).start;
        int end = input.get(0).end;

        for (int i = 1; i < input.size(); i++) {
            Interval interval = input.get(i);

            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
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