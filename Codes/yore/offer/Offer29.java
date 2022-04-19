package com.yore.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/6/23 9:35
 * @description
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int rowUp = 0;
        int colLeft = 0;
        int rowBottom = matrix.length;
        int colRight = matrix[0].length;

        int count = rowBottom * colRight;
        int i = 0;
        int row = 0, col = 0;
        int[] res = new int[count];
        while (i < count) {
            while (col < colRight) {
                res[i++] = matrix[row][col];
                col++;
            }
            if(i>=count){
                break;
            }
            col--;
            row++;
            rowUp++;
            while (row < rowBottom) {
                res[i++] = matrix[row][col];
                row++;
            }
            if(i>=count){
                break;
            }
            row--;
            col--;
            colRight--;
            while (col >= colLeft) {
                res[i++] = matrix[row][col];
                col--;
            }
            if(i>=count){
                break;
            }
            col++;
            row--;
            rowBottom--;
            while (row >= rowUp) {
                res[i++] = matrix[row][col];
                row--;
            }
            row++;
            col++;
            colLeft++;
        }
        return res;
    }

}
