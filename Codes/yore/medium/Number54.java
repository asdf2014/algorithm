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
            if(result.size() >= m * n) {
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


}
