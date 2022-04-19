package com.yore.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yore
 * @date 2022/1/29 12:46
 * @description
 */
public class Number1765 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] peak = new int[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            Arrays.fill(peak[i], -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    peak[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && peak[x][y] == -1) {
                    peak[x][y] = peak[p[0]][p[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return peak;
    }
}
