/**
 * ClassName:   Solution_74
 * Data:        2020/7/29
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:
输入:
matrix = [
  {1,   3,  5,  7},
  {10, 11, 16, 20},
  {23, 30, 34, 50}
]
target = 3
输出: true
示例 2:
输入:
matrix = [
  {1,   3,  5,  7},
  {10, 11, 16, 20},
  {23, 30, 34, 50}
]
target = 13
输出: false
 */
public class Solution_74 {
    public static void main(String[] args) {
        Solution_74 solution_74 = new Solution_74();
        System.out.println(solution_74.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        }, 5));
    }

    /*
    [
        {1,3,5,7},
        {10,11,16,20},
        {23,30,34,50}
    ]
    5
     */

    // 二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int mid;
        int bottom = m - 1, top = 0;
        int target_row = -1;
        while (top <= bottom) {
            mid = (top + bottom) / 2;
            if (matrix[mid][0] == target || target == matrix[mid][n - 1])
                return true;
            if (matrix[mid][0] < target && target < matrix[mid][n - 1]) {
                target_row = mid;
                break;
            }
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        if (target_row == -1) return false;
        int left = 0, right = n - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[target_row][mid] == target) return true;
            if (matrix[target_row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
