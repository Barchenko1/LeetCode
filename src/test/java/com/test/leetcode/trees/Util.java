package com.test.leetcode.trees;

public final class Util {
    public static TreeNode setupBST() {
        int[] values = {5, 3, 7, 2, 4, 6, 8};  // Sorted BST will be created

        TreeNode root = new TreeNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            root.insert(values[i]);
        }
        return root;
    }

    public static void print(TreeNode root) {
        print(root, 0);
    }


    private static void print(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        print(node.right, level + 1);

        System.out.println("    ".repeat(level) + node.val);

        print(node.left, level + 1);
    }
}
