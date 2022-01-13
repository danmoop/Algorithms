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

    /**
     *  https://interviewing.io/recordings/Java-Apple-2/
     */

    private static void solve() {
        int[] nums = {2, 1, 4, 3};
        int left = 2, right = 3;

        println(maxContiguousSubarray(nums, left, right));
        getParentheses(3);
    }

    /*
        Given an integer array nums and two integers left and right,
        return the number of contigious non-empty subarray such that
        the value of the maximum array element in that subarray is in the range [left, right]

        nums = [2, 1, 4, 3], left = 2, right = 3
        Answer = 3 (subarrays: [2], [2, 1], [3])
    */
    static int maxContiguousSubarray(int[] nums, int left, int right) {
        int max = -1, res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            if (max >= left && max <= right) {
                res++;
            } else {
                max = -1;
            }
        }

        return res;
    }

    /*
        Give n pairs of parentheses, write a function to generate all combinations of well-formed
        parentheses

        n = 2:
        ()()
        (())

        n = 3:
        ((()))
        (()())
        (())()
        ()(())
        ()()()
    */
    static void getParentheses(int n) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        rec(sb, stack, n * 2, n, n);
    }

    static void rec(StringBuilder sb, Stack<Character> stack, int n, int open, int close) {
        if (sb.length() == n) {
            println(sb.toString());
            return;
        }

        if (open > 0) {
            sb.append("(");
            stack.push('(');
            rec(sb, stack, n, open - 1, close);

            sb.deleteCharAt(sb.length() - 1);
            stack.pop();
        }

        if (close > 0 && !stack.isEmpty() && stack.peek() == '(') {
            sb.append(")");
            stack.pop();
            rec(sb, stack, n, open, close - 1);

            sb.deleteCharAt(sb.length() - 1);
            stack.push('(');
        }
    }
}