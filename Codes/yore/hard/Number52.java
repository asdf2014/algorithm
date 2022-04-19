package com.yore.hard;

/**
 * @author Yore
 * @date 2022/1/16 9:14
 * @description
 */
public class Number52 {
    public int totalNQueens(int n) {
        int[] record = new int[n];
        return func(n, record, 0);
    }

    public int func(int n, int[] record, int row) {
        if (row == n) {
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            if (isValidPos(record, row, col)) {
                record[row] = col;
                res += func(n, record, row + 1);
            }
        }
        return res;
    }

    public boolean isValidPos(int[] record, int row, int col) {
        for (int j = 0; j < row; j++) {
            if (col == record[j] || Math.abs(row - j) == Math.abs(col - record[j])) {
                return false;
            }
        }
        return true;
    }
}
