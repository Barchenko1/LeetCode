package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwapTwoWords {

    @Test
    public void test1() {
        String input = "abc12345";
        int firstWordLength = 3;

        char[] charArray = input.toCharArray();
        char[] result = stringsSwap(charArray, firstWordLength);
        Assertions.assertEquals("12345abc", new String(result));
    }

    public char[] stringsSwap(char[] charArray, int firstWordLength) {
        reverse(charArray, 0, firstWordLength - 1);
        reverse(charArray, firstWordLength, charArray.length - 1);
        reverse(charArray, 0, charArray.length - 1);
        return charArray;
    }

    private void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
