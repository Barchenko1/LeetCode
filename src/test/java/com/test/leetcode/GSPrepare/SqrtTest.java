package com.test.leetcode.GSPrepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrtTest {
    @Test
    public void test(){
        assertEquals(2, mySqrt1(4));
        assertEquals(2, mySqrt2(4));
    }

    private int mySqrt1(int x) {
        if (x == 0){
            return 0;
        }
        int res = 1;
        for (int i = 1; i <= x; i++) {
            if (i * i > x) {
                return res;
            }
            res = i;
        }
        return res;
    }

    private int mySqrt2(int x) {
        int l = 0;
        int r = x;
        int res = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m * m > x) {
                r = m - 1;
            } else if (m * m < x) {
                l = m + 1;
                res = m;
            } else  {
                return m;
            }
        }

        return res;
    }
}
