package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeNumber {
    /*
    Given an integer x, return true if x is a palindrome, and false otherwise.

    Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.
    Example 2:

    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

    Constraints:
    -231 <= x <= 231 - 1
    Follow up: Could you solve it without converting the integer to a string?
     */

    @Test
    public void test1() {
        Assertions.assertTrue(isPalindrome(121));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(isPalindrome(-121));
    }

    @Test
    public void test3() {
        Assertions.assertFalse(isPalindrome(10));
    }

    private boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char head = str.charAt(i);
            char tail = str.charAt(n - 1  - i);
            if (head != tail) {
                return false;
            }
        }
        return true;
    }
}
