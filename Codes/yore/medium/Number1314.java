package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/3 8:27
 * @description
 */
public class Number1314 {
    public static void main(String[] args) {
//        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = new int[][]{{76,4,73},{21,8,56},{4,56,61},{70,32,38},{31,94,67}};
        Number1314 n = new Number1314();
        System.out.println(n.matrixBlockSum(mat,1));
    }
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ps = new int[m][n];
        ps[0][0] = mat[0][0];
        for (int i = 1; i < n; i++) {
            ps[0][i] = ps[0][i - 1] + mat[0][i];
        }
        for (int j = 1; j < m; j++) {
            ps[j][0] = ps[j - 1][0] + mat[j][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ps[i][j] = ps[i][j - 1] + ps[i - 1][j] + mat[i][j] - ps[i - 1][j - 1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = Math.min(i + k, m - 1);
                int c = Math.min(j + k, n - 1);
                res[i][j] = ps[r][c];
                r = Math.max(-1, i - k - 1);
                c = Math.min(n - 1, j + k);
                int count = 0;
                if (r != -1) {
                    res[i][j] -= ps[r][c];
                    count++;
                }
                r = Math.min(m - 1, i + k);
                c = Math.max(j - k - 1, -1);
                if (c != -1) {
                    res[i][j] -= ps[r][c];
                    count++;
                }
                r = Math.max(i - k - 1, -1);
                c = Math.max(j - k - 1, -1);
                if (r != -1 && c != -1 && count==2) {
                    res[i][j] += ps[r][c];
                }
            }
        }
        return res;
    }
}
