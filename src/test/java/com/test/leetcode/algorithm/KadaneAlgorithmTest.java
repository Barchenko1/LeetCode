package com.test.leetcode.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KadaneAlgorithmTest {

    @Test
    public void test(){
        int[] nums = new int[]{4,-1,2,-7,3,4};
        assertEquals(7, kadanes(nums));
        assertArrayEquals(new int[]{4,5}, slidingWindow(nums));
    }

    public static int[] slidingWindow(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        int maxL = 0;
        int maxR = 0;
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (curSum < 0) {
                curSum = 0;
                L = R;
            }
            curSum += nums[R];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxL = L;
                maxR = R;
            }
        }
        return new int[] {maxL, maxR};
    }

    private int kadanes(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum, 0);
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }


}
