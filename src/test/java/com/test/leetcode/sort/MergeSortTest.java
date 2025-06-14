package com.test.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void test1(){
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] arr = new int[]{2, 3, 1, 5, 4};
        int[] result = mergeSort(arr, 0 , arr.length - 1);

        assertArrayEquals(expected, result);
        System.out.println(Arrays.toString(result));
    }

    private int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
        return arr;
    }

    private void merge(int[] arr, int l, int m, int r) {
        int lengthL = m - l + 1;
        int lengthR = r - m;

        int[] leftArray = new int[lengthL];
        int[] rightArray = new int[lengthR];

        for (int i = 0; i < lengthL; i++) {
            leftArray[i] = arr[l + i];
        }
        for (int j = 0; j < lengthR; j++) {
            rightArray[j] = arr[m + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < lengthL && j < lengthR) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                k++;
                i++;
            } else {
                arr[k] = rightArray[j];
                k++;
                j++;
            }
        }
        while (i < lengthL) {
            arr[k] = leftArray[i];
            k++;
            i++;
        }
        while (j < lengthR) {
            arr[k] = rightArray[j];
            k++;
            j++;
        }
    }
}
