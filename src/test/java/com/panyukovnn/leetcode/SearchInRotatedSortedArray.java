package com.panyukovnn.leetcode;

import org.junit.Test;

public class SearchInRotatedSortedArray {

    @Test
    public void test() {
        int[] nums = new int[]{4,5,6,7,8,9,0,1,2};

        System.out.println(search(nums, 0));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{4,5,6,7,0,1,2};

        System.out.println(search(nums, 3));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{3, 1};

        System.out.println(search(nums, 3));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
        System.out.println(end);

        if (start == 0) {
            end = nums.length - 1;
        } else {
            if (target >= nums[0]) {
                start = 0;
                end--;
            } else {
                end = nums.length - 1;
            }
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int midEl = nums[mid];

            if (midEl == target) {
                return mid;
            } else if (midEl >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
