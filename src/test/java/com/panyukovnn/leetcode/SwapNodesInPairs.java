package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.ListNode;
import org.junit.Test;

public class SwapNodesInPairs {

    @Test
    public void test() {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        printList(swapPairs(n1));
    }

    @Test
    public void test2() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        printList(swapPairs(n1));
    }

    @Test
    public void test3() {
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1, n2);

        printList(swapPairs(n1));
    }

    @Test
    public void test4() {
        ListNode n1 = new ListNode(1);

        printList(swapPairs(n1));
    }

    private void printList(ListNode currentNode) {
        while (true) {
            System.out.print(currentNode.val + " ");

            if (currentNode.next == null) {
                break;
            }

            currentNode = currentNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headToReturn = head.next;

        ListNode previousNode = null;
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        while (true) {
            ListNode nextNode = secondNode.next;

            if (previousNode != null) {
                previousNode.next = secondNode;
            }

            secondNode.next = firstNode;
            firstNode.next = nextNode;
            previousNode = firstNode;

            if (nextNode == null || nextNode.next == null) {
                return headToReturn;
            }

            firstNode = nextNode;
            secondNode = nextNode.next;
        }
    }
}
