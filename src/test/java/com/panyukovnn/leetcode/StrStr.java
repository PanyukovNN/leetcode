package com.panyukovnn.leetcode;

import org.junit.Test;

public class StrStr {

    @Test
    public void test() {
        System.out.println(strStr("abc", "c"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
