package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/15 8:46
 * @description
 */
public class Offer097 {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 < n2) {
            return 0;
        }
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = t.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n1][n2];
    }
}
