package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/

    @Test
    public void test1() {
        int[] result = new int[] {0,1};
        Assertions.assertArrayEquals(result, twoSum(new int[]{2,7,11,15}, 9));
        Assertions.assertArrayEquals(result, twoSum2(new int[]{2,7,11,15}, 9));
    }

    @Test
    public void test2() {
        int[] result = new int[] {1,2};
        Assertions.assertArrayEquals(result, twoSum(new int[]{3,2,4}, 6));
        Assertions.assertArrayEquals(result, twoSum2(new int[]{3,2,4}, 6));
    }

    @Test
    public void test3() {
        int[] result = new int[] {0,1};
        Assertions.assertArrayEquals(result, twoSum(new int[]{3,3}, 6));
        Assertions.assertArrayEquals(result, twoSum2(new int[]{3,3}, 6));
    }

    @Test
    public void test4() {
        int[] result = new int[] {0,1};
        Assertions.assertArrayEquals(result, twoSumNew(new int[]{2,7,11,15}, 9));
    }

    private int[] twoSumNew(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            for (int j = i; j < n - 1; j++) {
                if (nums[j] == diff) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }

    private int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }

    private int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                return new int[] {numMap.get(diff), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }







}
