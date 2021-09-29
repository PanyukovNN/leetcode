package com.panyukovnn.leetcode;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ValidParentheses {

    private final Map<Character, Character> openCloseBracket = new ImmutableMap.Builder<Character, Character>()
            .put('(', ')')
            .put('[', ']')
            .put('{', '}')
            .build();

    private final Set<Character> openBrackets = new HashSet<>(openCloseBracket.keySet());

    @Test
    public void test() {
        Map<String, Boolean> cases = new ImmutableMap.Builder<String, Boolean>()
                .put("()", true)
                .put("()[]{}", true)
                .put("(]", false)
                .put("([)]", false)
                .put("{[]}", true)
                .put("{", false)
                .build();

        cases.forEach((param, expected) -> assertEquals(expected, isValid(param)));
    }

    public boolean isValid(String s) {
        List<Character> parentheses = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (openBrackets.contains(currentChar)) {
                parentheses.add(currentChar);

                continue;
            }

            if (parentheses.isEmpty()) {
                return false;
            }

            char lastOpenBracket = parentheses.get(parentheses.size() - 1);
            parentheses.remove(parentheses.size() - 1);

            if (openCloseBracket.get(lastOpenBracket).equals(currentChar)) {
                continue;
            }

            return false;
        }

        return parentheses.isEmpty();
    }
}
