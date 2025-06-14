package com.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArraySort {

    @Test
    public void test1(){
        System.out.println(Arrays.toString(bubbleSort(new int[]{2, 3, 1, 5, 4})));
    }

    @Test
    public void test2(){
        System.out.println(Arrays.toString(insertSort(new int[]{2, 3, 1, 5, 4})));
    }

    @Test
    public void test3(){
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 3, 1, 5, 4}, 2, 3)));
    }

    private int[] mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int n = nums.length;
            int m = (l + r) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
        return nums;
    }

    private void merge(int[] nums, int l, int m, int r) {

    }

    private int[] insertSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int j = i-1;
            while(j >= 0 && arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
        return arr;
    }

    private int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
