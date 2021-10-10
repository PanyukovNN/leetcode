package com.panyukovnn.leetcode.util;

import com.panyukovnn.leetcode.model.ListNode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("Массив равен null.");

            return;
        }

        if (array.length == 0) {
            System.out.println("Массив пустой.");

            return;
        }

        String result = IntStream.of(array).boxed().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println(result);
    }

    public static void printListNode(ListNode node) {
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
