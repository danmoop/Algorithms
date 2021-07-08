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

    private static void solve() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        
        int s = 12;

        println(countPaths(root, s));
    }

    private static int countPaths(TreeNode tree, int target) {
        if (tree == null) return 0;
        return dfs(tree, 0, target) + countPaths(tree.left, target) + countPaths(tree.right, target);
    }

    private static int dfs(TreeNode tree, int sum, int target) {
        if (tree == null) return 0;
        int currentSum = sum + tree.val;

        if (tree.left == null && tree.right == null && currentSum == target) return 1;
        return dfs(tree.left, currentSum, target) + dfs(tree.right, currentSum, target);
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