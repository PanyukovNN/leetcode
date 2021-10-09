package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.util.Util;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 2};

        removeDuplicates(nums);

        Util.printArray(nums);
    }

    public int removeDuplicates(int[] nums) {
        // 1. Итерироваться по массиву двумя указателями
        // 2. Если встретили дубликат с предыдущим символом, то второй указатель
        //    останавливается
        // 3. Как только первый указатель находит отличный от предыдущего символа символ,
        //    то вставляет его в место, где расположен второй указатель
        // 4. Далее они продолжают движение

        int insertIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                int previousNum = nums[i - 1];

                if (previousNum != nums[i]) {
                    nums[insertIndex++] = nums[i];
                }
            } else {
                insertIndex++;
            }
        }

        return insertIndex;
    }
}
