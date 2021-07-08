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
        Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

        Example 1:
        Appointments: [[1,4], [2,5], [7,9]]
        Output: false
        Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.

        Example 2:
        Appointments: [[6,7], [2,4], [8,12]]
        Output: true
        Explanation: None of the appointments overlap, therefore a person can attend all of them.

        Example 3:
        Appointments: [[4,5], [2,3], [3,6]]
        Output: false
        Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
    */

    private static void solve() {
        List<Interval> input = new ArrayList<>();

        input.add(new Interval(4, 5));
        input.add(new Interval(2, 3));
        input.add(new Interval(3, 6));

        println(canAttendAllAppointments(input));
    }

    private static boolean canAttendAllAppointments(List<Interval> list) {
        Collections.sort(list, (l1, l2) -> l1.start - l2.start);

        for (int i = 1; i < list.size(); i++) {
            Interval now = list.get(i), prev = list.get(i - 1);
            if (now.start < prev.end) return false;
        }

        return true;
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