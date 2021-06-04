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
        Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that 
        the sum of all the node values of each path equals ‘S’.
    */

    private static void solve() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(root, 0, 12, list, paths);
        println(paths);
    }

    private static void dfs(TreeNode tree, int sum, int target, List<Integer> list, List<List<Integer>> paths) {
        if (tree == null) return;

        list.add(tree.val);

        if (tree.val + sum == target && (tree.left == null && tree.right == null)) {
            paths.add(new ArrayList<>(list));
        }

        dfs(tree.left, tree.val + sum, target, list, paths);
        dfs(tree.right, tree.val + sum, target, list, paths);
        list.remove(list.size() - 1);
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