package com.test.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void test1(){
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] arr = new int[]{2, 3, 1, 5, 4};
        int[] result = quickSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, result);
        System.out.println(Arrays.toString(result));
    }

    private int[] quickSort(int[] arr, int s, int e) {
        if (e - s + 1 <= 1) {
            return arr;
        }
        int pivot = arr[e];
        int leftPointer = s;
        for (int i = s; i < e; i++) {
            if (arr[i] < pivot) {
                int temp = arr[leftPointer];
                arr[leftPointer] = arr[i];
                arr[i] = temp;
                leftPointer++;
            }
        }
        arr[e] = arr[leftPointer];
        arr[leftPointer] = pivot;

        quickSort(arr, s, leftPointer - 1);
        quickSort(arr, leftPointer + 1, e);

        return arr;
    }
}
