package com.test.leetcode.trees;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static com.test.leetcode.trees.Util.print;
import static com.test.leetcode.trees.Util.setupBST;

public class BreadthFirstSearchTreeTest {
    @Test
    public void test1(){
        TreeNode root = setupBST();
        print(root);
        bfs(root);
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            System.out.println("level: " + level + ": ");
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode currentNode = queue.remove();
                System.out.println(currentNode.val + " ");
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            level++;
        }
    }
}
