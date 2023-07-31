package com.test.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.regex.Pattern;

public class BaseballGame {
    /*
    You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
    You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

    An integer x.
    Record a new score of x.
    '+'.
    Record a new score that is the sum of the previous two scores.
    'D'.
    Record a new score that is the double of the previous score.
    'C'.
    Invalidate the previous score, removing it from the record.
    Return the sum of all the scores on the record after applying all the operations.

    The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.



    Example 1:

    Input: ops = ["5","2","C","D","+"]
    Output: 30
    Explanation:
    "5" - Add 5 to the record, record is now [5].
    "2" - Add 2 to the record, record is now [5, 2].
    "C" - Invalidate and remove the previous score, record is now [5].
    "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
    "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
    The total sum is 5 + 10 + 15 = 30.
    Example 2:

    Input: ops = ["5","-2","4","C","D","9","+","+"]
    Output: 27
    Explanation:
    "5" - Add 5 to the record, record is now [5].
    "-2" - Add -2 to the record, record is now [5, -2].
    "4" - Add 4 to the record, record is now [5, -2, 4].
    "C" - Invalidate and remove the previous score, record is now [5, -2].
    "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
    "9" - Add 9 to the record, record is now [5, -2, -4, 9].
    "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
    "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
    The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
    Example 3:

    Input: ops = ["1","C"]
    Output: 0
    Explanation:
    "1" - Add 1 to the record, record is now [1].
    "C" - Invalidate and remove the previous score, record is now [].
    Since the record is empty, the total sum is 0.
     */

    @Test
    public void test1() {
        Assertions.assertEquals(30, calPoints(new String[] {"5","2","C","D","+"}));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(27, calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(0, calPoints(new String[] {"1","C"}));
    }

    private int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s:operations) {
            if ("+".equals(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int sum = num1 + num2;
                stack.push(num2);
                stack.push(num1);
                stack.push(sum);
            } else if ("D".equals(s)) {
                String top = String.valueOf(stack.peek() * 2);
                stack.push(Integer.parseInt(top));
            } else if ("C".equals(s)) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(s));
            }

        }
        int counter = 0;
        while (!stack.empty()) {
            counter += stack.pop();
        }
        return counter;
    }

//    private int calPoints(String[] operations) {
//        Stack<String> stack = new Stack<>();
//        int n = operations.length;
//        int counter = 0;
//        String regex1 = "\\S";
//        String regex2 = "\\d";
//        for (String s: operations) {
//            if (!Pattern.matches(regex1, s) || Pattern.matches(regex2, s)) {
//                stack.push(s);
//            } else {
//                if (stack.isEmpty()) {
//                    return counter;
//                }
//                if ("C".equals(s)) {
//                    stack.pop();
//                }
//                if ("D".equals(s)) {
//                    String top = String.valueOf(Integer.parseInt(stack.peek()) * 2);
//                    stack.push(top);
//                }
//                if ("+".equals(s)) {
//                    int num1 = Integer.parseInt(stack.pop());
//                    int num2 = Integer.parseInt(stack.pop());
//                    String sum = String.valueOf(num1 + num2);
//                    stack.push(String.valueOf(num2));
//                    stack.push(String.valueOf(num1));
//                    stack.push(sum);
//                }
//            }
//        }
//        while (!stack.isEmpty()) {
//            counter += Integer.parseInt(stack.pop());
//        }
//        return counter;
//    }
}
