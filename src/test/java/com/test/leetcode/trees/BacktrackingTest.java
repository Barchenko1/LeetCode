package com.test.leetcode.trees;

import org.junit.jupiter.api.Test;

import static com.test.leetcode.trees.Util.print;
import static com.test.leetcode.trees.Util.setupBST;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BacktrackingTest {
    @Test
    public void test1(){
        TreeNode root = setupBST();
        print(root);
        assertFalse(backtracking(root));
    }

    private boolean backtracking(TreeNode root) {
        if (root == null || root.val == 0) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        if (backtracking(root.left)) {
            return true;
        }
        if (backtracking(root.right)) {
            return true;
        }
        return false;
    }


}
