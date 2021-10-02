package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.ListNode;
import org.junit.Test;

public class MergeTwoSortedList {

    @Test
    public void test() {
        ListNode n3 = new ListNode(4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode m3 = new ListNode(4);
        ListNode m2 = new ListNode(3, m3);
        ListNode m1 = new ListNode(1, m2);

        printList(mergeTwoLists(n1, m1));
    }

    private void printList(ListNode currentNode) {
        while (true) {
            if (currentNode == null) {
                System.out.println("List is empty");

                return;
            }

            System.out.print(currentNode.val + " ");

            if (currentNode.next == null) {
                break;
            }

            currentNode = currentNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headToReturn = null;
        ListNode sortedList = null;

        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.val < l2.val)) {
                if (sortedList != null) {
                    sortedList.next = l1;
                } else {
                    headToReturn = l1;
                }

                sortedList = l1;
                l1 = l1.next;
            } else {
                if (sortedList != null) {
                    sortedList.next = l2;
                } else {
                    headToReturn = l2;
                }

                sortedList = l2;
                l2 = l2.next;
            }
        }

        return headToReturn;
    }
}
