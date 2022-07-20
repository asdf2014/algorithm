package com.yore.medium;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/5/25 8:30
 * @description
 */
public class Number467 {
    public static void main(String[] args) {
        Number467 number467 = new Number467();
        System.out.println(number467.findSubstringInWraproundString("abzabcdgh"));
    }

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(k, dp[p.charAt(i) - 'a']);
        }
        return Arrays.stream(dp).sum();
    }
}
