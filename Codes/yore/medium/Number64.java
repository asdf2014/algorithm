package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/6/15 9:16
 * @description
 */
public class Number64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else {
                    if (j - 1 < 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else if (i - 1 < 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
