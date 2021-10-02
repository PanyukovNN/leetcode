package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.ListNode;
import org.junit.Test;

public class RemoveNthNodeFromEndOfList {

    @Test
    public void test() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        printList(removeNthFromEnd(n1, 2));
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(1);

        printList(removeNthFromEnd(n1, 1));
    }

    @Test
    public void test3() {
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1, n2);

        printList(removeNthFromEnd(n1, 1));
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

    public ListNode removeNthFromEnd(final ListNode head, int n) {
        ListNode currentNode = head;
        ListNode removeNode = head;
        ListNode previousRemoveNode = null;

        while (currentNode.next != null) {
            currentNode = currentNode.next;

            if (--n <= 0) {
                previousRemoveNode = removeNode;
                removeNode = removeNode.next;
            }
        }

        if (previousRemoveNode != null)
            previousRemoveNode.next = removeNode.next;

        return removeNode == head
                ? removeNode.next
                : head;
    }
}
