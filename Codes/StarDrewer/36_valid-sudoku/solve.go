//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
//validated according to the following rules:
//
//
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
//without repetition.
//
//
// Note:
//
//
// A Sudoku board (partially filled) could be valid but is not necessarily
//solvable.
// Only the filled cells need to be validated according to the mentioned rules.
//
//
//
//
// Example 1:
//
//
//Input: board =
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
//
//
// Example 2:
//
//
//Input: board =
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner
//being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is
//invalid.
//
//
//
// Constraints:
//
//
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.
//
// Related Topics 数组 哈希表 矩阵 👍 631 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
const (
	lenRow        = 9
	lenCol        = 9
	rowSplit      = 3
	colSplit      = 3
	numRangeCount = 10
)

func isValidSudoku(board [][]byte) bool {
	hashRow := make([][]int, lenRow)
	hashCol := make([][]int, lenCol)
	for i := 0; i < len(hashRow); i++ {
		hashRow[i] = make([]int, numRangeCount)
		hashCol[i] = make([]int, numRangeCount)
	}
	hashSet := make([][][]int, lenRow/rowSplit)
	for i := 0; i < len(hashSet); i++ {
		hashSet[i] = make([][]int, lenCol/colSplit)
		for j := 0; j < len(hashSet[i]); j++ {
			hashSet[i][j] = make([]int, numRangeCount)
		}
	}
	for row, bytes := range board {
		for col, b := range bytes {
			if b == '.' {
				continue
			}
			val := b - '0'
			// 规则1、2、3
			if hashRow[row][val] == 1 || hashCol[col][val] == 1 || hashSet[row/(lenRow/rowSplit)][col/(lenCol/colSplit)][val] == 1 {
				return false
			}
			hashRow[row][val]++
			hashCol[col][val]++
			hashSet[row/(lenRow/rowSplit)][col/(lenCol/colSplit)][val]++
		}
	}
	return true
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(isValidSudoku([][]byte{}))
}
