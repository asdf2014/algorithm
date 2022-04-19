package com.yore.medium;

/**
 * @author Yore
 * @date 2022/4/14 10:36
 * @description
 */
public class Number79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[][] visit = new int[m][n];
                if (find(i, j, board, word, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(int r, int c, char[][] board, String word, int index, int[][] visit) {
        int m = board.length;
        int n = board[0].length;
        int[][] operation = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (index == word.length()) {
            return true;
        }
        boolean flag = false;
        if (board[r][c] == word.charAt(index)) {
            visit[r][c] = 1;
            if (index + 1 == word.length()) {
                return true;
            }
            for (int[] op : operation) {
                int i = r + op[0];
                int j = c + op[1];
                if (i >= 0 && i < m && j >= 0 && j < n && visit[i][j] != 1) {
                    flag |= find(i, j, board, word, index + 1, visit);
                    visit[i][j] = 0;
                }
            }
        }
        return flag;
    }
}
