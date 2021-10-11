package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.util.Util;
import org.junit.Test;

public class FirstMissingPositive {

    /*
        1. Итерироваться по массиву, если число положительное и не совпадает со своим индексом+1 то поменять местами
           повторить операцию до тех пор, пока текущее число не станет негативным, либо большим чем размер массива,
           либо 0, либо не совпадет с текущим индексом (если числа, которые меняем местами равны - пропускаем)
        2. Если число равно 0, либо отрицательное, либо превышает размер массива - пропускаем
        3. Повторно пробегаем по массиву, если встречаем число не совпадающее со своим индекосом - то это именно оно
     */

    @Test
    public void test() {
        int[] nums = new int[]{3,4,-1,1};

        System.out.println(firstMissingPositive(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1,2,0};

        System.out.println(firstMissingPositive(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{7,8,9,11,12};

        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n != i + 1) {
                if (n > 0 && n <= nums.length) {
                    if (nums[i] == nums[n - 1]) {
                        nums[i] = 0;
                        continue;
                    }

                    int temp = nums[i];
                    nums[i] = nums[n - 1];
                    nums[n - 1] = temp;
                    i--;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length;
    }
}
