package com.test.leetcode.heap;

import org.junit.jupiter.api.Test;

public class MaxHeapifyTest {

    @Test
    public void test1() {
        int[] arr = {3, 9, 2, 1, 4, 5};

        buildMaxHeap(arr);

        System.out.println("Heapified array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
