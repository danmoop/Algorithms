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

    /*
        Problem Statement #
        Given an array of characters where each character represents a fruit tree, 
        you are given two baskets and your goal is to put maximum number of fruits in each basket. 
        The only restriction is that each basket can have only one type of fruit.

        You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

        Write a function to return the maximum number of fruits in both the baskets.

        Example 1:

        Input: Fruit=['A', 'B', 'C', 'A', 'C']
        Output: 3
        Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
        Example 2:

        Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
        Output: 5
        Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
        This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
    */

    private static void solve() {
        char[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0;

        while(j < fruits.length) {
            set.add(fruits[j++]);

            if(set.size() > 2) {
                char left = fruits[i];
                set.remove(left);
                while(fruits[i] == left) i++;
            }

            res = Math.max(res, j - i);
        }

        println(res);
    }
}