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
        Given a binary tree and a node, find the level order successor of the given node in the tree. 
        level order successor is the node that appears right after the given node in the level order traversal.
    */

    private static void solve() {
        TreeNode root= new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(10);

        println(findSuccessor(root, 12));
    }

    private static int findSuccessor(TreeNode tree, int key) {
        if (tree == null) return 0;
        boolean isNextItemASuccessor = false;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(tree);

        while (!list.isEmpty()) {
            TreeNode front = list.poll();
            if (isNextItemASuccessor) return front.val;

            if (front.val == key) {
                isNextItemASuccessor = true;
            }

            if (front.left != null) list.offer(front.left);
            if (front.right != null) list.offer(front.right);
        }

        return -1;
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