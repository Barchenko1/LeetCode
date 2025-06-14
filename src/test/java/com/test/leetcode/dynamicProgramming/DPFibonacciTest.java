package com.test.leetcode.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DPFibonacciTest {

    @Test
    public void test() {
        assertEquals(5, bruteForce(5));
        assertEquals(5, memoization(5, new int[6]));
        assertEquals(5, dp(5));
    }

    private int bruteForce(int n) {
        if (n <= 1) {
            return n;
        }
        return bruteForce(n-1) + bruteForce(n-2);
    }

    private int memoization(int n, int[] cache) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = memoization(n-1, cache) + memoization(n-2, cache);
        return cache[n];
    }

    private int dp(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[] {0, 1};
        int i = 2;
        while (i <= n) {
            int temp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0] = temp;
            i++;
        }
        return dp[1];
    }
}
