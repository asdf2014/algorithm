package com.yore.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/4/27 8:56
 * @description
 */
public class Number417 {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pa = new boolean[m][n];
        boolean[][] at = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pa);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pa);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, at);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, at);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pa[i][j] && at[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }

    public void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && heights[x][y] >= heights[row][col]) {
                dfs(x, y, ocean);
            }
        }
    }
}
