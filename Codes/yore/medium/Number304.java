package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/3 9:12
 * @description
 */
public class Number304 {
    private int[][] ps;

    public Number304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ps = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] + matrix[i][j] - ps[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return ps[row2 + 1][col2 + 1] - ps[row2 + 1][col1] - ps[row1][col2 + 1] + ps[row1][col1];
    }
}
