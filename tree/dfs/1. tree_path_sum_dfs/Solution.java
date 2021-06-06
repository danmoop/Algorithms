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
        Given a binary tree and a number ‘S’, 
        find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
    */

    private static void solve() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        println(hasSum(root, 0, 18));
    }

    private static boolean hasSum(TreeNode tree, int sum, int target) {
        if(tree.val + sum == target && tree.left == null && tree.right == null) return true;

        if(tree.left != null && hasSum(tree.left, tree.val + sum, target)) return true;
        if(tree.right != null && hasSum(tree.right, tree.val + sum, target)) return true;

        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right; 

        TreeNode(int val) {
            this.val = val;
        }
    }
}