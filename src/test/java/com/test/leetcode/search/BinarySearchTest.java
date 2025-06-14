package com.test.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @Test
    public void test1(){
        int[] arr = {1, 3, 3, 4, 5, 6, 7, 8};
        int result = binarySearch(arr, 6);

        assertEquals(5, result);
        System.out.println(result);
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;

        while (l <= r) {
            m = (l + r) / 2;
            if (target > nums[m]) {
                l = m + 1;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
