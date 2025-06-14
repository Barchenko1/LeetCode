package com.test.leetcode.GSPrepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTwoSortedArraysTest {
    @Test
    public void test() {
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{3,4,5,6,7};
        assertEquals(4.0, medianTwoSortedArrays(nums1, nums2));
    }

    private double medianTwoSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return medianTwoSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                int pivot = (x + y) % 2;
                if (pivot == 0) {
                    return ((double)Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double)Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0;
    }
}
