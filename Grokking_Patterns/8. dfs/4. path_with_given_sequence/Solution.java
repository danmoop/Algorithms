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

    // Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

    private static void solve() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);

        int[] sequence = {1, 9, 2};

        println(findPath(root, sequence, 0));
    }

    private static boolean findPath(TreeNode tree, int[] sequence, int index) {
        if (tree == null || index >= sequence.length || sequence[index] != tree.val) return false;
        if (tree.left == null && tree.right == null && tree.val == sequence[index]) return true;

        return findPath(tree.left, sequence, index + 1) || findPath(tree.right, sequence, index + 1);
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