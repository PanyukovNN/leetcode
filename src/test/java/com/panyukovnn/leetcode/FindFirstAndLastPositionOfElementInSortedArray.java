package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.util.Util;
import org.junit.Test;

public class FindFirstAndLastPositionOfElementInSortedArray {

    @Test
    public void test() {
        int[] nums = new int[]{5,7,7,8,8,8,8,8,10};
        int target = 8;

        Util.printArray(searchRange(nums, target));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findMostLeft(nums, target), findMostRight(nums, target)};
    }

    private int findMostLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midEl = nums[mid];

            if (midEl == target && (mid == 0 || nums[mid - 1] != target)) {
                return mid;
            } else if (midEl >= target) {
                end = mid - 1;
            } else if (midEl < target) {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int findMostRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midEl = nums[mid];

            if (midEl == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                return mid;
            } else if (midEl > target) {
                end = mid - 1;
            } else if (midEl <= target) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
