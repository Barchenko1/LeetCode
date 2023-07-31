package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ValidParentheses {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"
    Output: true
    Example 2:

    Input: s = "()[]{}"
    Output: true
    Example 3:

    Input: s = "(]"
    Output: false


    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
     */

    @Test
    public void test1() {
        Assertions.assertTrue(isValid("()"));
    }

    @Test
    public void test2() {
        Assertions.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void test3() {
        Assertions.assertFalse(isValid("(]"));
    }

    @Test
    public void test4() {
        Assertions.assertTrue(isValid("([])"));
    }

    @Test
    public void test5() {
        Assertions.assertFalse(isValid("(])"));
    }

    boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '[' || chars[i] == '(' || chars[i] == '{') {
                characterStack.push(chars[i]);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                char top = characterStack.peek();
                if ((chars[i] == ')' && top == '(')
                        || (chars[i] == ']' && top == '[')
                        || (chars[i] == '}' && top == '{')) {
                    characterStack.pop();
                } else {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
}
