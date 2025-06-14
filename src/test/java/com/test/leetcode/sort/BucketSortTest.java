package com.test.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BucketSortTest {
    @Test
    public void test1(){
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] arr = new int[]{2, 3, 1, 5, 4};
        int[] result = bucketSot(arr);

        assertArrayEquals(expected, result);
        System.out.println(Arrays.toString(result));
    }

    private int[] bucketSot(int[] arr) {
        int[] counts = new int[] {0, 0 ,0, 0, 0, 0};
        for (int k : arr) {
            counts[k] += 1;
        }

        int i = 0;
        for (int n = 0; n < counts.length; n++) {
            for (int j = 0; j < counts[n]; j++) {
                arr[i] = n;
                i++;
            }
        }

        return arr;
    }
}
