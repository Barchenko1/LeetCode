package com.test.leetcode.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoPointerAlgorithmTest {
    @Test
    public void test() {
        assertTrue(isPalindrome("abba"));
        int[] nums = {-1,2,3,4,7,9};
        int target = 7;
        assertArrayEquals(new int[] {2,3}, targetSum(nums, target));
    }

    private boolean isPalindrome(String word) {
        int L = 0;
        int R = word.length() - 1;

        while (L < R) {
            if (word.charAt(L) != word.charAt(R)) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

    private int[] targetSum(int[] nums, int k) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            if (nums[L] + nums[R] > k) {
                R--;
            } else if (nums[L] + nums[R] < k) {
                L++;
            } else {
                return new int[] {L, R};
            }
        }

        return null;
    }
}
