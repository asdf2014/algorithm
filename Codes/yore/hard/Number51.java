package com.yore.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/15 16:24
 * @description 从左到右遍历模式，n的n次方问题，优化只能在常数项
 * 这里多了打印结果的步骤，所以要考虑状态还原的问题
 * 判断有效位置，只需考虑是否在同一列，是否在对角线 对角线的判断通过坐标差值巧妙比较
 */
public class Number51 {
    public static void main(String[] args) {
        Number51 number51 = new Number51();
        List<List<String>> result = number51.solveNQueens(4);
        System.out.println(result.size());
        for (List<String> l : result) {
            System.out.println("[");
            for (String s : l) {
                System.out.print(s);
                System.out.println();
            }
            System.out.println("]");
        }
    }

    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        int[][] path = new int[n][n];
        func(n, record, 0, path);
        return res;
    }

    public void func(int n, int[] record, int row, int[][] path) {
        if (row == n) {
            List<String> t = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = 0; j < n; j++) {
                    if (path[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                t.add(sb.toString());
            }
            res.add(t);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidPos(record, row, col)) {
                record[row] = col;
                path[row][col] = 1;
                func(n, record, row + 1, path);
                path[row][col] = 0;
            }
        }
    }

    public boolean isValidPos(int[] record, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == record[i] || Math.abs(row - i) == Math.abs(col - record[i])) {
                return false;
            }
        }
        return true;
    }
}
