package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int length = 1;

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;

        int offset = length - k % length;
        current = head;

        for (int i = 0; i < offset - 1; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }
}
