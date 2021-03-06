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
        Problem Statement
        Given a binary tree where each node can only have a digit (0-9) value, 
        each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
    */

    private static void solve() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(1);

        println(findSum(root, 0));
    }

    private static int findSum(TreeNode tree, int sum) {
        if (tree == null) return 0;
        int newSum = sum * 10 + tree.val;

        if (tree.left == null && tree.right == null) {
            return newSum;
        }

        return findSum(tree.left, newSum) + findSum(tree.right, newSum);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right; 

        TreeNode(int val) {
            this.val = val;
        }

        @Override 
        public String toString() {
            return "value: " + val + ", left: " + left + ", right: " + right;
        }
    }
}