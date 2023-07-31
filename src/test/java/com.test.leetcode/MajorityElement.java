package com.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorityElement {

    /*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2


    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109

    Follow-up: Could you solve the problem in linear time and in O(1) space?
     */

    //Moore Voting Algorithm

    @Test
    public void test1() {
        Assertions.assertEquals(3, majorityElement(new int[] {3,2,3}));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(2, majorityElement(new int[] {1,2,2,1,1,2,2,2,1}));
    }


    private int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
