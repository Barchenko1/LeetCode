package com.test.leetcode.graph;

import org.junit.jupiter.api.Test;

public class DFSMatrixTest {
    int[][] grid = {
            {0, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 1},
            {0, 1, 0, 0}
    };

    @Test
    public void test(){
        int[][] visit = new int[grid.length][grid[0].length];
        int totalPaths = dfs(grid, 0, 0, visit);
        System.out.println("Total Unique Paths: " + totalPaths);
    }

    private int dfs(int[][] grid, int r, int c, int[][] visit) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (Math.min(r, c) < 0 || r == rows || c == cols || visit[r][c] == 1 || grid[r][c] == 1) {
            return 0;
        }
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }
        visit[r][c] = 1;

        int count = 0;
        count += dfs(grid, r + 1, c, visit);
        count += dfs(grid, r - 1, c, visit);
        count += dfs(grid, r, c + 1, visit);
        count += dfs(grid, r, c - 1, visit);

        visit[r][c] = 0;
        return count;
    }
}
