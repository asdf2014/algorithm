import java.util.ArrayList;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_36
 * Data:        2020/7/19
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
36. 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
数独部分空格内已填入了数字，空白格用 '.' 表示。
示例 1:
输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:
输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 */
public class Solution_36 {
    public boolean isValidSudoku1(char[][] board) {
        int len = board.length;
        ArrayList<Character> row = new ArrayList<>();
        ArrayList<Character> col = new ArrayList<>();
        ArrayList<Character> block = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int b_r = i%3 * 3;
            for (int j = 0; j < len; j++) {
                int b_c = j/3 + i/3 * 3;
                if (board[i][j] != '.' && row.contains(board[i][j]))
                    return false;
                else
                    row.add(board[i][j]);
                if (board[j][i] != '.' && col.contains(board[j][i]))
                    return false;
                else
                    col.add(board[j][i]);
                if (board[b_r][b_c] != '.' && block.contains(board[b_r][b_c]))
                    return false;
                else
                    block.add(board[b_r][b_c]);
                if (j%3 == 2)
                    b_r = i%3 * 3;
                else
                    b_r ++;
            }
            row.clear();
            col.clear();
            block.clear();
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];
        int len = board.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int block_index = j/3 + i/3 * 3;
                if (row[i][num] != 1 && col[j][num] != 1 && block[block_index][num] != 1){
                    row[i][num] = 1;
                    col[j][num] = 1;
                    block[block_index][num] = 1;
                }else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] boards = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution_36 solution_36 = new Solution_36();
        System.out.println(solution_36.isValidSudoku(boards));
    }
}
