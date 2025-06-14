package com.test.leetcode.trees;

import org.junit.jupiter.api.Test;

import static com.test.leetcode.trees.Util.print;
import static com.test.leetcode.trees.Util.setupBST;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryInsertRemoveTreeTest {

    @Test
    public void test1(){
        TreeNode root = setupBST();
        print(root);
        root = insert(root, 9);
        System.out.println("------------");
        print(root);
        remove(root, 8);
        System.out.println("------------");
        print(root);
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    private TreeNode remove(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val > root.val){
            root.right = remove(root.right, val);
        } else if (val < root.val) {
            root.left = remove(root.left, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = remove(root.right, root.val);
            }
        }
        return root;
    }

    private TreeNode minValueNode(TreeNode root) {
        TreeNode current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }
}
