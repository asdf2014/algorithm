package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/2/22 15:28
 * @description
 */
public class Offer013 {
    class NumMatrix {
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            dp = new int[m][n];
            dp[0][0] = matrix[0][0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + matrix[0][i];
            }
            for (int j = 1; j < m; j++) {
                dp[j][0] = dp[j - 1][0] + matrix[j][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = dp[row2][col2];
            if (row1 - 1 >= 0) {
                sum -= dp[row1 - 1][col2];
            }
            if (col1 - 1 >= 0) {
                sum -= dp[row2][col1 - 1];
            }
            if (row1 - 1 >= 0 && col1 - 1 >= 0) {
                sum += dp[row1 - 1][col1 - 1];
            }
            return sum;
        }
    }
}
