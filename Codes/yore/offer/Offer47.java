package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/2 10:14
 * @description
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int upValue = i - 1 >= 0 ? dp[i - 1][j] : 0;
                int leftValue = j - 1 >= 0 ? dp[i][j - 1] : 0;
                dp[i][j] = Math.max(upValue, leftValue) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
