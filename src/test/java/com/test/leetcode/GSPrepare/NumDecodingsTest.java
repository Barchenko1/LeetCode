package com.test.leetcode.GSPrepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumDecodingsTest {
    @Test
    public void test() {
        assertEquals(2, numDecodings("12"));
        assertEquals(3, numDecodings("226"));
    }

    private int numDecodings(String s) {
        int dp = 0;
        int dp1 = 1;
        int dp2 = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp = 0;
            } else {
                dp = dp1;
                if (i + 1 < s.length() &&
                        (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp += dp2;
                }
            }
            dp2 = dp1;
            dp1 = dp;
            dp = 0;
        }
        return dp1;
    }
}
