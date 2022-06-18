package com.yore.easy;

/**
 * @author Yore
 * @date 2022/4/26 9:09
 * @description
 */
public class Number883 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xy = 0;
        int[] yz = new int[n];
        int[] xz = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    xy++;
                }
                yz[j] = Math.max(grid[i][j], yz[j]);
                xz[i] = Math.max(grid[i][j], xz[i]);
            }
        }
        int res = 0;
        res += xy;
        for (int i = 0; i < n; i++) {
            res += xz[i];
            res += yz[i];
        }
        return res;
    }
}
