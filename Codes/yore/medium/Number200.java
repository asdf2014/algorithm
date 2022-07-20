package com.yore.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/7/17 10:12
 * @description
 */
public class Number200 {
    private int[][] position = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Number200 number200 = new Number200();
        System.out.println(number200.numIslands(new char[][]{{'0','1','0'},{'1','0','1'},{'0','1','0'}}));
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][] visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 1 || grid[i][j] == '0') {
                    continue;
                }
                searchGrid(grid, i, j, visit);
                res += 1;
            }
        }
        return res;
    }

    public void searchGrid(char[][] grid, int r, int c, int[][] visit) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{r, c});
        visit[r][c] = 1;
        while (!queue.isEmpty()) {
            int[] cad = queue.pollFirst();
            for (int[] pos : position) {
                int x = cad[0] + pos[0];
                int y = cad[1] + pos[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    if (grid[x][y] != '0' && visit[x][y] == 0) {
                        visit[x][y] = 1;
                        queue.offerLast(new int[]{x, y});
                    }
                }
            }
        }
    }
}
