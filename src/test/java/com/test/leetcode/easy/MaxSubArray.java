package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSubArray {

/*
    Given an integer array nums, find the
    subarray with the largest sum, and return its sum.

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    Example 2:
    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.
    Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

    Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

    Follow up: If you have figured out the O(n) solution,
    try coding another solution using the divide and conquer approach, which is more subtle.
 */

    @Test
    public void test1() {
        Assertions.assertEquals(6, maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, maxSubArray(new int[] {1}));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(23, maxSubArray(new int[] {5,4,-1,7,8}));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(23, maxSubArray2(new int[] {5,4,-1,7,8}));
    }

    private int maxSubArray2(int[] nums) {
        int n = nums.length;
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    private int maxSubArray(int[] nums) {
        int n = nums.length;
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
