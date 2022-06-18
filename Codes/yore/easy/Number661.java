package com.yore.easy;

/**
 * @author Yore
 * @date 2022/3/24 8:18
 * @description
 */
public class Number661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] avg = new int[m][n];
        int[][] op = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                avg[i][j] = cal(img, i, j, op, m, n);
            }
        }
        return avg;
    }

    public int cal(int[][] img, int x, int y, int[][] op, int m, int n) {
        int sum = 0;
        int count = 0;
        for (int[] cad : op) {
            int r = x + cad[0];
            int c = y + cad[1];
            if (r >= 0 && r < m && c >= 0 && c < n) {
                sum += img[r][c];
                count++;
            }
        }
        return (int) Math.floor((double) sum / count);
    }
}
