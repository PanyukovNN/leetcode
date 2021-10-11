package com.panyukovnn.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    @Test
    public void test() {
        int[] nums = new int[]{1,0,1,1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer firstIndex = valueIndex.get(nums[i]);
            if (firstIndex != null) {
                if (i - firstIndex <= k) {
                    return true;
                }
            }

            valueIndex.put(nums[i], i);
        }

        return false;
    }
}
