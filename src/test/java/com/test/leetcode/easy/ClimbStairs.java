package com.test.leetcode.easy;

import org.junit.jupiter.api.Test;

public class ClimbStairs {

    @Test
    public void test1() {
        System.out.println(climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = step1 + step2;
            step2 = step1;
            step1 = result;
        }

        return result;
    }
}
