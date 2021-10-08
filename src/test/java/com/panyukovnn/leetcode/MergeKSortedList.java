package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MergeKSortedList {

    @Test
    public void test() {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        n11.next = n12;
        ListNode n13 = new ListNode(5);
        n12.next = n13;

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        n21.next = n22;
        ListNode n23 = new ListNode(4);
        n22.next = n23;

        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(6);
        n31.next = n32;

        ListNode[] lists = new ListNode[3];
        lists[0] = n11;
        lists[1] = n21;
        lists[2] = n31;

        printList(mergeKLists(lists));
    }

    /*
            Шаг 1. Как только все текущие ноды равны null - возвращаем результат
            Шаг 2. Пробегаем по всем нодам, сравниваем текущие значения с переменной, находим наименьшее значение и запоминаем какая была нода
            Шаг 3. Добавляем ноду с наименьшим значением в результирующий список, при этом храним ссылку на голову
         */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHead = null;
        ListNode resultList = null;

        while (true) {
            ListNode minNode = null;
            Integer minValue = null;
            Integer nodeIndex = null;

            for (int i = 0; i < lists.length; i++) {
                ListNode currentNode = lists[i];

                if (currentNode != null && (minNode == null || currentNode.val < minValue)) {
                    minNode = currentNode;
                    minValue = currentNode.val;
                    nodeIndex = i;
                }
            }

            if (minNode == null) {
                break;
            }

            lists[nodeIndex] = minNode.next;

            if (resultHead == null) {
                resultHead = minNode;
                resultList = minNode;
            } else {
                resultList.next = minNode;
                resultList = minNode;
            }
        }

        return resultHead;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);

            if (node.next != null) {
                System.out.print(" -> ");
            }

            node = node.next;
        }

        System.out.print("\n");
    }
}
