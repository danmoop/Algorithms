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
        Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the 
        sum of all the node values of each path equals ‘S’.

        Example 1: 
        S: 12
        Output: 2Explaination: There are the two paths with sum '12':1 -> 7 -> 4 and 1 -> 9 -> 2 
     
        Example 2: 
        S: 23
        Output: 2Explaination: Here are the two paths with sum '23':12 -> 7 -> 4 and 12 -> 1 -> 10 
    */

    private static void solve() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        println(findPaths(root, 23));
    }

    private static List<List<Integer>> findPaths(TreeNode tree, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(tree, target, 0, path, res);

        return res;
    }

    private static void helper(TreeNode tree, int target, int sum, List<Integer> path, List<List<Integer>> list) {
        if (tree == null) return;
        path.add(tree.val);

        if (tree.left == null && tree.right == null && sum + tree.val == target) {
            list.add(new ArrayList<>(path));
        }

        helper(tree.left, target, sum + tree.val, path, list);
        helper(tree.right, target, sum + tree.val, path, list);

        path.remove(path.size() - 1);
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