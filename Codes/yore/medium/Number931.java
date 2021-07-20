package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/5/27 9:03
 * @description
 */
public class Number931 {
    int[][] matrixLocal;
    int[][] memory;

    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int result = Integer.MAX_VALUE;
        memory = new int[len][len];
        matrixLocal = matrix;
        for (int i = 0; i < len; i++) {
            result = Math.min(result, dp(len - 1, i));
        }
        return result;
    }

    public int dp(int i, int j) {
        if (i < 0 || j < 0 || i >= matrixLocal.length || j >= matrixLocal.length) {
            return 100000;
        }
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        if (i == 0) {
            return matrixLocal[i][j];
        }
        memory[i][j] = matrixLocal[i][j] + Math.min(dp(i - 1, j - 1),
                Math.min(dp(i - 1, j), dp(i - 1, j + 1)));
        return memory[i][j];
    }
}
