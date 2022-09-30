package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yore
 * @date 2021/3/16 15:58
 * @description
 */
public class Number54 {

    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);

        int i = 0;
        int j = 0;

        int lowRow = 0, highRow = m - 1, lowCol = 0, highCol = n - 1;

        while (result.size() < m * n) {
            while (j <= highCol) {
                result.add(matrix[lowRow][j++]);
            }
            lowRow++;
            i = lowRow;
            while (i <= highRow) {
                result.add(matrix[i++][highCol]);
            }
            if (result.size() >= m * n) {
                break;
            }
            highCol--;
            j = highCol;
            while (j >= lowCol) {
                result.add(matrix[highRow][j--]);
            }
            highRow--;
            i = highRow;
            while (i >= lowRow) {
                result.add(matrix[i--][lowCol]);
            }
            lowCol++;
            j = lowCol;
        }
        return result;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = m * n;
        int r = 0;
        int c = 0;
        int route = 0;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int bottom = m - 1;
        List<Integer> res = new ArrayList<>();
        while (cnt > 0) {
            res.add(matrix[r][c]);
            switch (route) {
                case 0:
                    if (c == right) {
                        route = 1;
                        r++;
                        up++;
                    } else {
                        c++;
                    }
                    break;
                case 1:
                    if (r == bottom) {
                        route = 2;
                        c--;
                        right--;
                    } else {
                        r++;
                    }
                    break;
                case 2:
                    if (c == left) {
                        route = 3;
                        r--;
                        bottom--;
                    } else {
                        c--;
                    }
                    break;
                case 3:
                    if (r == up) {
                        route = 0;
                        c++;
                        left++;
                    } else {
                        r--;
                    }
            }
            cnt--;
        }
        return res;
    }
}
