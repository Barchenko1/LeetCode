package com.test.leetcode.graph;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class BFSMatrixTest {
    int[][] grid = {
            {0, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 1},
            {0, 1, 0, 0}
    };

    @Test
    public void test(){
        int totalPaths = bfs(grid);
        System.out.println("Total Unique Paths: " + totalPaths);
    }

    private int bfs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visit = new int[rows][cols];
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[2]);
        visit[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                if (r == rows - 1 && c == cols - 1) {
                    return length;
                }
                int[][] neighbors = {{r, c+1}, {r, c-1}, {r+1,c}, {r-1, c}};
                for (int j = 0; j < rows; j++) {
                    int newRow = neighbors[j][0];
                    int newCol = neighbors[j][1];
                    if (Math.min(newRow, newCol) < 0 || newRow == rows || newCol == cols
                            || visit[newRow][newCol] == 1 || grid[newRow][newCol] == 1) {
                        continue;
                    }
                    queue.add(neighbors[j]);
                    visit[newRow][newCol] = 1;
                }
            }
            length++;
        }

        return length;
    }
}
