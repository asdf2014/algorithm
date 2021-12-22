package com.yore.medium;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/5/19 8:19
 * @description
 */
public class Number1738 {

    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}}, 10));
    }


    public static int kthLargestValue(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int[][] xOrValue = new int[row][col];
        int left = 0;
        int up = 0;
        int leftUp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                leftUp = (i - 1 >= 0 && j - 1 >= 0) ? xOrValue[i - 1][j - 1] : 0;
                up = (i - 1 >= 0) ? xOrValue[i - 1][j] : 0;
                left = (j - 1 >= 0) ? xOrValue[i][j - 1] : 0;
                xOrValue[i][j] = left ^ up ^ leftUp ^ matrix[i][j];
                res[i * col + j] = xOrValue[i][j];
            }
        }
        Arrays.sort(res);
        return res[row*col-k];
    }


}
