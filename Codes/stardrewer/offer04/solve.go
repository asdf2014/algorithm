package main

func findNumberIn2DArray(matrix [][]int, target int) bool {
	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])
	if n == 0 {
		return false
	}

	for i, j := 0, 0; ; {

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
