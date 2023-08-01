package com.test.leetcode;

import com.test.leetcode.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeTwoLists {
    /*
    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

    Return the head of the merged linked list.



    Example 1:


    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]
    Example 2:

    Input: list1 = [], list2 = []
    Output: []
    Example 3:

    Input: list1 = [], list2 = [0]
    Output: [0]


    Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
     */

    @Test
    public void test1() {
        //expected
        ListNode node6 = new ListNode(4);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        //actual
        ListNode node3_1 = new ListNode(4);
        ListNode node2_1 = new ListNode(2, node3_1);
        ListNode node1_1 = new ListNode(1, node2_1);

        ListNode node3_2 = new ListNode(4);
        ListNode node2_2 = new ListNode(3, node3_2);
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
        ListNode actualNode = mergeTwoLists(node1_1, node1_2);
        System.out.print(" -> ");
        while (actualNode != null) {
            System.out.print(actualNode.val + " -> ");
            actualNode = actualNode.next;
        }
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode root = new ListNode();
        ListNode prev = root;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;
        return root.next;
    }
}
