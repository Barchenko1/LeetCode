package com.test.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RotatingArray {

    @Test
    public void test(){
        int[] expectedArray = new int[]{5,6,7,1,2,3,4};
        int[] array = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(expectedArray));
        int[] result = rotate(array, 3);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(expectedArray, result);
    }

    private int[] rotate(int[] nums, int k) {
        int n = nums.length;

        reverse(nums, 0, n - 1 - k);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

        return nums;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
