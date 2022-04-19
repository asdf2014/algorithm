package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/24 14:37
 * @description
 */
public class Number1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int row = 0;
            int col = i;
            while (row < m) {
                int next = col + grid[row][col];
                if (next < 0 || next >= n || grid[row][col] != grid[row][next]) {
                    col = -1;
                    break;
                }
                row++;
                col = next;
            }
            res[i] = col;
        }
        return res;
    }
}
