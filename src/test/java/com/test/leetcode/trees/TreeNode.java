package com.test.leetcode.trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void insert(int newVal) {
        if (newVal < this.val) {
            if (this.left == null) this.left = new TreeNode(newVal);
            else this.left.insert(newVal);
        } else {
            if (this.right == null) this.right = new TreeNode(newVal);
            else this.right.insert(newVal);
        }
    }
}
