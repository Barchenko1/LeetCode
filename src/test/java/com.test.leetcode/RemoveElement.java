package com.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveElement {

    @Test
    public void test1() {
        Assertions.assertEquals(5, removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(2, removeElement(new int[] {3,2,2,3}, 3));
    }

    private int removeElement(int[] nums, int val) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
