package com.test.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertSortTest {

    @Test
    public void test1(){
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] arr = new int[]{2, 3, 1, 5, 4};
        int[] result = insertSort(arr);

        assertArrayEquals(expected, result);
        System.out.println(Arrays.toString(result));
    }

    private int[] insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j + 1] < arr[j]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }


}
