package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Palindrome {

    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.
    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.
    Example 3:

    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.


    Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.
     */

    @Test
    public void test1() {
        Assertions.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(isPalindrome("race a car"));
    }

    @Test
    public void test3() {
        Assertions.assertTrue(isPalindrome(" "));
    }

    @Test
    public void test4() {
        Assertions.assertFalse(isPalindrome("a.b,."));
    }

    private boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        }
        int headPointer = 0;
        int tailPointer = str.length() - 1;
        for (int i = 0; headPointer <= tailPointer; i++) {
            char cHead = str.charAt(headPointer);
            char cTail = str.charAt(tailPointer);
            if (!Character.isLetterOrDigit(cHead)) {
                headPointer++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tailPointer--;
            } else {
                headPointer++;
                tailPointer--;
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
            }
        }
        return true;
    }
}
