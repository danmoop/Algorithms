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

    private static void arrayFillRandom(int[] arr, int bound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * bound);
        }
    }

    private static void shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor(Math.random() * arr.length);

            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    // BST insertion functions - both iterative and recursive

    public static void main(String[] args) {
        sc = new FastScanner();

        solve();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right; 

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void solve() {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(12);

        insertIteratively(root, 8);
        insertRecursively(root, 13);
    }

    private static TreeNode insertRecursively(TreeNode tree, int val) {
        if (tree == null) return new TreeNode(val);

        if (val >= tree.val) {
            tree.right = insertRecursively(tree.right, val);
        } else {
            tree.left = insertRecursively(tree.left, val);
        }

        return tree;
    }

    private static void insertIteratively(TreeNode tree, int val) {
        TreeNode temp = tree;

        boolean ok = false;
        while (true) {
            if (val >= temp.val) {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            }
        }
    }
}