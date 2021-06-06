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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.left.right = new TreeNode(10);
        root.right.left.left.left = new TreeNode(13);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(12);
        root.right.right.left = new TreeNode(11);

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

    // Return elements of a tree level-by-level in a spiral order

    private static void solve() {
        TreeNode root = createTree();
        List<Integer> nums = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean shouldReverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                if (shouldReverse) {
                    list.add(0, first.val);
                } else {
                    list.add(first.val);
                }

                if (first.left != null) queue.offer(first.left);
                if (first.right != null) queue.offer(first.right);
            }
            shouldReverse = !shouldReverse;

            for (int i: list) {
                nums.add(i);
            }
        }
        println(nums);
    }
}