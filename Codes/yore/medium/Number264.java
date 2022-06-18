package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/28 8:36
 * @description
 */
public class Number264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        int[] factors = new int[]{2, 3, 5};
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (num2 == dp[i]) {
                p2++;
            }
            if (num3 == dp[i]) {
                p3++;
            }
            if (num5 == dp[i]) {
                p5++;
            }
        }
        return dp[n];
    }
}
