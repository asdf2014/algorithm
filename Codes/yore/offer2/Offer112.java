package com.yore.offer2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/19 9:08
 * @description
 */
public class Offer112 {
    public static void main(String[] args) {
        Offer112 o = new Offer112();
        System.out.println(o.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] op = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] a : dp) {
            Arrays.fill(a, 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Deque<int[]> queue = new LinkedList<>();
                queue.offerLast(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] a = queue.pollFirst();
                    int x = a[0];
                    int y = a[1];
                    for (int k = 0; k < 4; k++) {
                        int r = x - op[k][0];
                        int c = y - op[k][1];
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            if (matrix[r][c] > matrix[x][y] && dp[r][c] < dp[x][y] + 1) {
                                dp[r][c] = dp[x][y] + 1;
                                queue.offerLast(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        int max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
