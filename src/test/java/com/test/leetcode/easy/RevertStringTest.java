package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RevertStringTest {

    @Test
    public void test1() {
        String str = "abcdefg";
        String reverseStr = revertString(str);
        Assertions.assertEquals("gfedcba", reverseStr);
        System.out.println(str);
        System.out.println(reverseStr);
    }

    private String revertString(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char head = str.charAt(i);
            char tail = str.charAt(len - i - 1);
            chars[i] = tail;
            chars[len - i -1] = head;
        }

        return new String(chars);
    }
}
