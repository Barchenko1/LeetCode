package com.test.leetcode.GSPrepare;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestTest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    @Test
    public void test1(){
        int[] nums = {3,2,1,5,6,4};
        assertEquals(5, kth(nums, 2));
        assertEquals(5, findKthLargest(nums, 2));
    }

    private int[] mergeSort(int[] nums, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(nums, l, m);
            mergeSort(nums, m+1, r);
            merge(nums, l, m ,r);
        }
        return nums;
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

    private int kth(int[] nums, int k) {
        int[] sortedNums = mergeSort(nums, 0, nums.length - 1);
        return sortedNums[nums.length - k];
    }

    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }


}
