package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/6/7 9:43
 * @description
 */
public class Number583 {
    public int minDistance(String word1, String word2) {
        int len = longestCommonSubsequence(word1, word2);
        return word1.length() - len + word2.length() - len;
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
