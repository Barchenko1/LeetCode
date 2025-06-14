package com.test.citi;

import java.util.Arrays;

public class Citi {
    // app 1 to n, no duplicates

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,3,2,5,7,6,8};
        int[] sort = new int[] {1,2,3,5};
        int[] arr2 = new int[] {4,3,2,5,7,6,8};
        int[] arr3 = new int[] {4,3,2,5,7,6,1};

        int arrCount = 5;
        System.out.println(findOneNumber(arr3));
    }

    private static int findOneNumber(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] >= arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            if (arr[0] > 1) {
                return arr[0] - 1;
            }
            if (arr[i] < arr[i + 1] - 1) {
                return arr[i] + 1;
            }
            if (arr[n - 1] != n + 1) {
                return n + 1;
            }
        }
        return 0;
    }
}
