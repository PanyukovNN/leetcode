package com.panyukovnn.leetcode;

import org.junit.Test;

public class ReverseInteger {

    @Test
    public void test() {
        System.out.println(reverse(120));
    }

    public int reverse(int x) {
        int result = 0;
        boolean isNegative = x < 0;

        if (isNegative) {
            x = -x;
        }

        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }

            result *= 10;
            int n = x % 10;
            result += n;

            x /= 10;
        }

        return isNegative ? -result : result;
    }
}
