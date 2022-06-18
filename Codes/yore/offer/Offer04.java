package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/5/28 15:21
 * @description
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length ==0) {
            return false;
        }
        int col = matrix[0].length;

        for (int[] ints : matrix) {
            int j = 0;
            if (ints[j] > target) {
                return false;
            }
            while (j < col && ints[j] < target) {
                j++;
            }
            if (j < col && ints[j] == target) {
                return true;
            }
        }
        return false;
    }
}
