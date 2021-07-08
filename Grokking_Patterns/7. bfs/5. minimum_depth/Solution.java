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
        Find the minimum depth of a binary tree. The minimum depth is the number of nodes 
        along the shortest path from the root node to the nearest leaf node.
    */

    private static void solve() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.left.left = new TreeNode(11);
        root.right.right = new TreeNode(5);

        println(minDepth(root));
    }

    private static int minDepth(TreeNode tree) {
        if (tree == null) return 0;

        if (tree.left == null) {
            return 1 + minDepth(tree.right);
        } else if (tree.right == null) {
            return 1 + minDepth(tree.left);
        }

        return 1 + Math.min(minDepth(tree.left), minDepth(tree.right));
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