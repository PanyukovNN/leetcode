package com.panyukovnn.leetcode.util;

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
}
