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
            return Integer.parseInt(ns());
        }

        public String ns() {
            return sc.next();
        }

        public long nl() {
            return sc.nextLong();
        }

        public double nd() {
            return sc.nextDouble();
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right; 

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(14);

        return root;
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
        PRAMP
        Given a root of a Binary Search Tree (BST) and a number num, implement 
            an efficient function findLargestSmallerKey that finds the largest key 
            in the tree that is smaller than num. If such a number doesn’t exist, return -1. 
            Assume that all keys in the tree are nonnegative.
        Analyze the time and space complexities of your solution.
    */

    private static void solve() {
        TreeNode root = createTree();
        int key = sc.ni();
        println(findLargestSmallerKey(root, key));
    }

    private static int findLargestSmallerKey(TreeNode tree, int key) {
        int res = -1;
        TreeNode temp = tree;

        while (temp != null) {
            if (key <= temp.val) {
                temp = temp.left;
            } else {
                res = temp.val;
                temp = temp.right;
            }
        }

        return res;
    }
}