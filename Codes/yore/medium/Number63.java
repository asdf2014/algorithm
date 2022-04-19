package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/4 8:18
 * @description
 */
public class Number63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return dp[m][n];
    }
}
