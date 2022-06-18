package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/2/23 16:42
 * @description
 */
public class Offer105 {
    public static void main(String[] args) {
        Offer105 o = new Offer105();
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(o.maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] cal = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cal[i][j] == 1) {
                    continue;
                }
                if (grid[i][j] == 0) {
                    cal[i][j] = 1;
                    continue;
                }
                cal[i][j] = 1;
                maxArea = Math.max(maxArea, searchArea(grid, i, j, cal));
                System.out.println(maxArea);
            }
        }
        return maxArea;
    }

    public int searchArea(int[][] grid, int row, int col, int[][] cal) {
        int curArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        Deque<Candidate> queue = new LinkedList<>();
        queue.offerLast(new Candidate(row, col));
        while (!queue.isEmpty()) {
            Candidate cad = queue.pollFirst();
            int r = cad.x;
            int c = cad.y;
            curArea++;
            if (r - 1 >= 0 && grid[r - 1][c] == 1 && cal[r - 1][c] != 1) {
                cal[r - 1][c] = 1;
                queue.offerLast(new Candidate(r - 1, c));
            }
            if (r + 1 < m && grid[r + 1][c] == 1 && cal[r + 1][c] != 1) {
                cal[r + 1][c] = 1;
                queue.offerLast(new Candidate(r + 1, c));
            }
            if (c - 1 >= 0 && grid[r][c - 1] == 1 && cal[r][c - 1] != 1) {
                cal[r][c - 1] = 1;
                queue.offerLast(new Candidate(r, c - 1));
            }
            if (c + 1 < n && grid[r][c + 1] == 1 && cal[r][c + 1] != 1) {
                cal[r][c + 1] = 1;
                queue.offerLast(new Candidate(r, c + 1));
            }
        }
        return curArea;
    }

    class Candidate {
        int x;
        int y;

        Candidate(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
}
