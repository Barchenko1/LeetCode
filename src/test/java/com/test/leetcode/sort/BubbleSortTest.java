package com.test.leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void test1(){
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] arr = new int[]{2, 3, 1, 5, 4};
        int[] result = bubbleSort(arr);

        assertArrayEquals(expected, result);
        System.out.println(Arrays.toString(result));
    }

    private int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
