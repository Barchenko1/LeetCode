package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListGetConcatenation {

    /*
    Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
    Specifically, ans is the concatenation of two nums arrays.
    Return the array ans.
    Example 1:

    Input: nums = [1,2,1]
    Output: [1,2,1,1,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
    - ans = [1,2,1,1,2,1]
    Example 2:

    Input: nums = [1,3,2,1]
    Output: [1,3,2,1,1,3,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
    - ans = [1,3,2,1,1,3,2,1]

    Constraints:

    n == nums.length
    1 <= n <= 1000
    1 <= nums[i] <= 1000
     */

    @Test
    public void test1() {
        Assertions.assertArrayEquals(new int[]{1,2,1,1,2,1}, getConcatenation(new int[]{1,2,1}));
    }

    @Test
    public void test2() {
        Assertions.assertArrayEquals(new int[]{1,3,2,1,1,3,2,1}, getConcatenation(new int[]{1,3,2,1}));
    }

    private int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int midPoint = n;
        int[] result = new int[n * 2];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
            result[midPoint] = nums[i];
            midPoint++;
        }
        return result;
    }
}
