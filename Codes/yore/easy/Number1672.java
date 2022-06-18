package com.yore.easy;

/**
 * @author Yore
 * @date 2022/4/14 9:36
 * @description
 */
public class Number1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int row = accounts.length;
        int col = accounts[0].length;
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
