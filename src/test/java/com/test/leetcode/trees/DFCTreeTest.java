package com.test.leetcode.trees;

import org.junit.jupiter.api.Test;

import static com.test.leetcode.trees.Util.print;
import static com.test.leetcode.trees.Util.setupBST;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DFCTreeTest {

    @Test
    public void test1(){
        TreeNode root = setupBST();
        inOrder(root);
        System.out.println();
        System.out.println("--------------");
        preOrder(root);
        System.out.println();
        System.out.println("--------------");
        postOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
