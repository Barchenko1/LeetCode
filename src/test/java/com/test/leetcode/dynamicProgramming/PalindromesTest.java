package com.test.leetcode.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromesTest {
    @Test
    public void test() {
        assertEquals(4, isPalindrome("abaab"));
    }

    private int isPalindrome(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            length = Math.max(length, helder(s, i, i));
            length = Math.max(length, helder(s, i, i + 1));
        }

        return length;
    }

    private int helder(String s, int l, int r) {
        int maxLength = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > maxLength) {
                maxLength = r - l + 1;
            }
            l--;
            r++;
        }
        return maxLength;
    }
}
