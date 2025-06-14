package com.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Fibonacci {

    @Test
    public void test1(){
        System.out.println(Arrays.toString(fibonacci(10)));
    }

    private int[]fibonacci(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[0] = 0;
            }
            else if (i == 1) {
                result[1] = 1;
            } else {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result;
    }
}
