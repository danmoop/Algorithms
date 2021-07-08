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
        Given two lists of intervals, find the intersection of these two lists. Each list consists of 
        disjoint intervals sorted on their start time.

        Example 1:
        Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
        Output: [2, 3], [5, 6], [7, 7]
        Explanation: The output list contains the common intervals between the two lists.

        Example 2:
        Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
        Output: [5, 7], [9, 10]
        Explanation: The output list contains the common intervals between the two lists.
    */

    private static void solve() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(9, 12));

        List<Interval> input2 = new ArrayList<>();
        input2.add(new Interval(5, 10));

        println(findIntersection(input, input2));
    }

    private static List<Interval> findIntersection(List<Interval> list1, List<Interval> list2) {
        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            Interval first = list1.get(i), second = list2.get(j);

            while (first.end < second.start) first = list1.get(++i);
            while (second.end < first.start) second = list2.get(++j);

            res.add(new Interval(Math.max(first.start, second.start), Math.min(first.end, second.end)));

            if (first.end < second.end) {
                i++;
            } else {
                j++;
            }
        }

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