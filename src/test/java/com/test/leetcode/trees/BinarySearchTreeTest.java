package com.test.leetcode.trees;

import org.junit.jupiter.api.Test;

import static com.test.leetcode.trees.Util.print;
import static com.test.leetcode.trees.Util.setupBST;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {

    @Test
    public void test1(){
        TreeNode root = setupBST();
        print(root);
        assertTrue(search(root, 8));
    }

    private boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (target > root.val) {
            return search(root.right, target);
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return true;
        }
    }
}
