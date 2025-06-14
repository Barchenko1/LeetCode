package com.test.leetcode.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DPMatrixTest {

    int[][] grid = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    @Test
    public void test() {
        assertEquals(20, bruteForce(0, 0, 4, 4));
        assertEquals(20, memoization(0, 0, 4, 4, new int[4][4]));
        assertEquals(20, dp(4, 4));
    }

    private int bruteForce(int r, int c, int rows, int cols) {
        if (r == rows || c == cols) {
            return 0;
        }
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }
        return (bruteForce(r + 1, c, rows, cols) +
                bruteForce(r, c + 1, rows, cols));
    }

    private int memoization(int r, int c, int rows, int cols, int[][] cache) {
        if (r == rows || c == cols) {
            return 0;
        }
        if (cache[r][c] > 0) {
            return cache[r][c];
        }
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }
        cache[r][c] = (memoization(r + 1, c, rows, cols, cache) + memoization(r, c + 1, rows, cols, cache));
        return cache[r][c];
    }

    private int dp(int rows, int cols) {
        int[] prevRow = new int[cols];

        for (int i = rows - 1; i >= 0; i--) {
            int[] curRow = new int[cols];
            curRow[cols - 1] = 1;
            for(int j = cols - 2; j >= 0; j--) {
                curRow[j] = curRow[j + 1] + prevRow[j];
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}
