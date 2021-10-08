package com.panyukovnn.leetcode;

import org.junit.Test;
import java.util.*;

/**
 * Задача от Тинькофф
 * Даны два отсортированных массива целых чисел, объединить их в один массив без дубликатов и вернуть результат
 */
public class MergeTwoSortedArrays {

    @Test
    public void test() {
        int[] arr1 = new int[]{1, 3, 4, 6, 7, 8};
        int[] arr2 = new int[]{1, 2, 3, 5, 6};

        int[] result = mergeArrays(arr1, arr2);

        printArray(result);
    }

    public int[] mergeArrays(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;

        int[] result = new int[arr1.length + arr2.length];

        while (index1 != arr1.length || index2 != arr2.length) {
            if (index1 == arr1.length || (index2 != arr2.length && arr1[index1] > arr2[index2])) {
                if (addElement(result, arr2[index2++], resultIndex)) {
                    resultIndex++;
                }
            } else {
                if (addElement(result, arr1[index1++], resultIndex)) {
                    resultIndex++;
                }
            }
        }

        return result;
    }

    public boolean addElement(int[] arr, int el, int lastIndex) {
        if (lastIndex != 0 && arr[lastIndex - 1] == el) {
            return false;
        }

        arr[lastIndex] = el;

        return true;
    }

    private void printArray(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}
