package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/14 9:31
 * @description
 */
public class Offer094 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (isParl(s, j, i - 1)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n] - 1;
    }


    public boolean isParl(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
