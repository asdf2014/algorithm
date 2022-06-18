package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/10 9:20
 * @description
 */
public class Number279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = 1 + min;
        }
        return dp[n];
    }
}
