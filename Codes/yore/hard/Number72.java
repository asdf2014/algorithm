package com.yore.hard;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/6/10 8:51
 * @description
 */
public class Number72 {
    private String word1;
    private String word2;
    private int[][] memory;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        memory = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memory[i], -1);
        }
        return dp(word1.length() - 1, word2.length() - 1);
    }

    public int dp(int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memory[i][j] != -1) {
            return memory[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memory[i][j] = dp(i - 1, j - 1);
        } else {
            memory[i][j] = Math.min(dp(i, j - 1) + 1, Math.min(dp(i - 1, j) + 1, dp(i - 1, j - 1) + 1));
        }
        return memory[i][j];
    }


    int minDistance1(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
