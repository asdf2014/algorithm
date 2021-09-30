//Write an efficient algorithm that searches for a target value in an m x n
//integer matrix. The matrix has the following properties:
//
//
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -10⁹ <= matrix[i][j] <= 10⁹
// All the integers in each row are sorted in ascending order.
// All the integers in each column are sorted in ascending order.
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 分治 矩阵 👍 735 👎 0

package main

import "fmt"

//leetcode submit region begin(Prohibit modification and deletion)
func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	n := len(matrix[0])
	for i, j := 0, 0; i < m && j < n; {

		if matrix[i][j] <= target && target <= matrix[i][n-1] {
			for k := j; k < n; k++ {
				if matrix[i][k] == target {
					return true
				}
			}
		}

		if matrix[i][j] <= target && target <= matrix[m-1][j] {
			for k := i; k < m; k++ {
				if matrix[k][j] == target {
					return true
				}
			}
		}

		if i < m-1 {
			i++
		}
		if j < n-1 {
			j++
		}
		if i == m-1 && j == n-1 {
			if matrix[i][j] == target {
				return true
			}
			break
		}
	}
	return false
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(searchMatrix([][]int{{-5}}, -5))
	fmt.Println(searchMatrix([][]int{{-1, 3}}, 3))
	fmt.Println(searchMatrix([][]int{{1, 4}, {2, 5}}, 5))
}
