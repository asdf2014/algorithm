package com.yore.medium;

/**
 * @author Yore
 * @date 2022/6/11 8:58
 * @description
 */
public class Number926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] zeroDp = new int[n];
        int[] oneDp = new int[n];
        if (s.charAt(0) == '0') {
            zeroDp[0] = 0;
        } else {
            zeroDp[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeroDp[i] = zeroDp[i - 1];
                oneDp[i] = Math.min(zeroDp[i - 1], oneDp[i - 1]) + 1;
            } else {
                zeroDp[i] = zeroDp[i - 1] + 1;
                oneDp[i] = Math.min(zeroDp[i - 1], oneDp[i - 1]);
            }
        }
        return Math.min(zeroDp[n - 1], oneDp[n - 1]);
    }
}
