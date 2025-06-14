package com.test.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeSearchTest {
    @Test
    public void test1(){
        int result = binarySearch(1, 8);

        assertEquals(5, result);
        System.out.println(result);
    }

    private int isCorrect(int n) {
        if (n > 10) {
            return 1;
        } else if (n < 10) {
            return -1;
        }
        return 0;
    }

    private int binarySearch(int l, int r) {
        int m;

        while (l <= r) {
            m = (l + r) / 2;
            if (isCorrect(m) > 0) {
                r = m - 1;
            } else if (isCorrect(m) < 0) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
