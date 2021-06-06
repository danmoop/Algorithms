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
        Given a binary tree, find the root-to-leaf path with the maximum sum
    */
    static List<Integer> max;
    static int mx = 0;

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

        dfs(root, 0, list, paths);
        println(max);
        println(mx);
    }

    private static void dfs(TreeNode tree, int sum, List<Integer> list, List<List<Integer>> paths) {
        if (tree == null) return;

        list.add(tree.val);

        if (tree.left == null && tree.right == null) {
            if (tree.val + sum > mx) {
                mx = tree.val + sum;
                max = new ArrayList<>(list);
            }
        }

        dfs(tree.left, tree.val + sum, list, paths);
        dfs(tree.right, tree.val + sum, list, paths);
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