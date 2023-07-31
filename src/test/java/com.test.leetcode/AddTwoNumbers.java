package com.test.leetcode;

import com.test.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbers {
    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
    Example 2:

    Input: l1 = [0], l2 = [0]
    Output: [0]
    Example 3:

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
    Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.
     */

    @Test
    public void test1() {
        int[] l1 = new int[]{2, 4, 3};
        int[] l2 = new int[]{5, 6, 4};
        Assertions.assertArrayEquals(new int[]{7, 0, 8}, addTwoNumbers(l1, l2));
    }

    @Test
    public void test2() {
        int[] l1 = new int[]{0};
        int[] l2 = new int[]{0};
        Assertions.assertArrayEquals(new int[]{0}, addTwoNumbers(l1, l2));
    }

    @Test
    public void test3() {
        int[] l1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] l2 = new int[]{9, 9, 9, 9};
        Assertions.assertArrayEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, addTwoNumbers(l1, l2));
    }

    private int[] addTwoNumbers(int[] l1, int[] l2) {
        ListNode listNode = new ListNode();
        int n = Math.max(l1.length, l2.length);
        int[] result = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int n1 = l1.length > i ? l1[i] : 0;
            int n2 = l2.length > i ? l2[i] : 0;
            int sum = n1 + n2;
            if (temp > 1) {
                temp = 1;
            }
            if (sum + temp > 9) {
                int s = sum % 10 + temp == 10 ? 0 : sum % 10 + temp;
                result[i] = s;
                temp++;
            } else {
                result[i] = sum + temp;
                temp = 0;
            }


        }
        return result;
    }

}

