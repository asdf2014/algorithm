package com.yore.easy;

/**
 * @author Yore
 * @date 2022/4/19 8:55
 * @description
 */
public class Number821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        int index = -2 * n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                index = i;
            }
            ans[i] = i - index;
        }
        index = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i;
            }
            ans[i] = Math.min(ans[i], index - i);
        }
        return ans;
    }
}
