package com.test.leetcode.easy;

import com.test.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseList {
    /*
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example 1:

    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
    Example 2:


    Input: head = [1,2]
    Output: [2,1]
    Example 3:

    Input: head = []
    Output: []


    Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000
     */

    @Test
    public void test1() {
        //expected
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        //actual
        ListNode node5_2 = new ListNode(5);
        ListNode node4_2 = new ListNode(4, node5_2);
        ListNode node3_2 = new ListNode(3, node4_2);
        ListNode node2_2 = new ListNode(2, node3_2);
        ListNode node1_2 = new ListNode(1, node2_2);

        System.out.println("expected");
        System.out.print(" -> ");
        while (node1 != null) {
            System.out.print(node1.val + " -> ");
            node1 = node1.next;
        }
        System.out.println();
        System.out.println("-----------------");
        System.out.println("actual");
        ListNode actualNode = reverseList(node1_2);
        System.out.print(" -> ");
        while (actualNode != null) {
            System.out.print(actualNode.val + " -> ");
            actualNode = actualNode.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;

    }
}

