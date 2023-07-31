package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    /*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: true
    Example 2:

    Input: nums = [1,2,3,4]
    Output: false
    Example 3:

    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true
     */

    @Test
    public void test1() {
        Assertions.assertFalse(containsDuplicate(new int[] {1,2,3,4}));
        Assertions.assertFalse(containsDuplicate2(new int[] {1,2,3,4}));
    }

    @Test
    public void test2() {
        Assertions.assertTrue(containsDuplicate(new int[] {1,2,3,1}));
        Assertions.assertTrue(containsDuplicate2(new int[] {1,2,3,1}));
    }

    @Test
    public void test3() {
        Assertions.assertTrue(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
        Assertions.assertTrue(containsDuplicate2(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }

    private boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsDuplicate2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (seen.containsKey(nums[i]) && seen.get(nums[i]) >= 1) {
                return true;
            }
            seen.put(nums[i], seen.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}
