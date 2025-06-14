package com.test.leetcode.GSPrepare;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumIslandsTest {
    int[][] grid = {
            {1,1,0,0,1},
            {1,1,0,0,1}, 
            {0,0,1,0,0}, 
            {0,0,0,1,1}
    };

    @Test
    public void test() {
        assertEquals(4, numIslands(grid));
    }

    private int numIslands(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };
        grid[r][c] = 0;
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir: directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length &&
                        nc < grid[0].length && grid[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
        }
    }
}
