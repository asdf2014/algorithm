package com.yore.medium;

/**
 * @author Yore
 * @date 2022/4/22 9:28
 * @description
 */
public class Number73 {

    public static void main(String[] args) {
        Number73 number73 = new Number73();
        number73.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }

    int[][] opt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, tmp[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    process(tmp, i, j, m, n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(tmp[i], 0, matrix[i], 0, n);
        }
    }

    void process(int[][] tmp, int r, int c, int m, int n) {
        for (int[] op : opt) {
            int i = r + op[0];
            int j = c + op[1];
            while (i >= 0 && i < m && j >= 0 && j < n) {
                tmp[i][j] = 0;
                i += op[0];
                j += op[1];
            }
        }
    }


public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j] =0;
                }
            }
        }
    }
}
