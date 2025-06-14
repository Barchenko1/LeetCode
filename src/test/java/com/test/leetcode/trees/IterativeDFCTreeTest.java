package com.test.leetcode.trees;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.test.leetcode.trees.Util.setupBST;

public class IterativeDFCTreeTest {

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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                System.out.print(cur.val + " ");
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.left;
            } else {
                cur = stack.pop();
            }
        }
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        stack.push(root);
        visit.push(false);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            boolean visited = visit.pop();
            if (cur != null) {
                if (visited) {
                    System.out.print(cur.val + " ");
                } {
                    stack.push(cur);
                    visit.push(true);
                    stack.push(cur.right);
                    visit.push(false);
                    stack.push(cur.left);
                    visit.push(false);
                }
            }
        }
    }
}
