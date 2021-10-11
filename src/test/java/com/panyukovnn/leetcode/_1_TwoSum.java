package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.util.Util;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {

    @Test
    public void test() {
        int[] result = twoSum(new int[]{3, 2, 4}, 6);

        Util.printArray(result);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> expectedNums = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            if (expectedNums.get(nums[i]) != null) {
                return new int[]{expectedNums.get(nums[i]), i};
            }

            expectedNums.put(target - nums[i], i);
        }

        return null;
    }
}
