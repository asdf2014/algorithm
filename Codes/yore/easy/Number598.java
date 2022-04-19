package com.yore.easy;

/**
 * @author Yore
 * @date 2021/11/7 17:03
 * @description
 */
public class Number598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for(int[] op : ops){
            if(op[0]<minRow){
                minRow = op[0];
            }
            if(op[1]<minCol){
                minCol = op[1];
            }
        }
        return minRow * minCol;
    }
}
