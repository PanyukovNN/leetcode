package com.panyukovnn.leetcode;

import org.junit.Test;

import java.util.*;

public class ThreeSum {

    @Test
    public void test() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};

        System.out.println(threeSum(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{};

        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        boolean allZeros = true;
        for (int num : nums) {
            if (num != 0) {
                allZeros = false;
                break;
            }
        }
        if (allZeros) {
            return new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }

            List<List<Integer>> expectedValues = twoSum(nums, -nums[i], i);

            if (!expectedValues.isEmpty()) {
                int value = nums[i];
                expectedValues.forEach(l -> l.add(value));

                for (List<Integer> list : expectedValues) {
                    if (!contains(answer, list)) {
                        answer.add(list);
                    }
                }
            }
        }

        return answer;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int ignoreIndex) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> expectedNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == ignoreIndex) {
                continue;
            }

            if (expectedNums.get(nums[i]) != null) {
                List<Integer> resultList = new ArrayList<>();
                resultList.add(target - nums[i]);
                resultList.add(nums[i]);

                result.add(resultList);
            }

            expectedNums.put(target - nums[i], i);
        }

        return result;
    }

    private boolean contains(List<List<Integer>> lists, List<Integer> comparedList) {
        comparedList.sort(Integer::compareTo);

        for (List<Integer> list : lists) {
            boolean isEqual = true;
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals(comparedList.get(i))) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                return true;
            }
        }

        return false;
    }
}
