package com.test.leetcode.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlidingWindowTest {
    @Test
    public void test(){
        int[] nums = {1,2,3,2,3,3};
        assertTrue(slidingWindow(nums, 3));
        int[] nums1 = {4,2,2,3,3,3};
        assertEquals(3, slidingWindow2(nums1));
    }

    private boolean slidingWindow(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            if (R - L + 1 > k) {
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }
        return false;
    }

    private int slidingWindow2(int[] nums) {
        int length = 0;
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            if (nums[L] != nums[R]) {
                L = R;
            }
            length = Math.max(length, R - L + 1);
        }
        return length;
    }
}
