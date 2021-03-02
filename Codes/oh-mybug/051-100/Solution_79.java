/**
 * ClassName:   Solution_79
 * Data:        2020/7/30
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 */
public class Solution_79 {
    public static void main(String[] args) {
        System.out.println(new Solution_79().exist(new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        }, "AAB"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] track = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0))
                    continue;
                if (helper(board, word, 0, i, j, track))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int index, int row, int col, boolean[][] track) {
        if (word.length() == index)
            return true;
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || word.charAt(index) != board[row][col])
            return false;
        if (!track[row][col]) {
            track[row][col] = true;
            if (helper(board, word, index + 1, row, col + 1, track)
                    || helper(board, word, index + 1, row, col - 1, track)
                    || helper(board, word, index + 1, row + 1, col, track)
                    || helper(board, word, index + 1, row - 1, col, track))
                return true;
            track[row][col] = false;
        }
        return false;
    }
}
