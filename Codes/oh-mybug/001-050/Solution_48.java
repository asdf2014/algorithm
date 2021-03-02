/**
 * ClassName: Solution_48
 * Date:      2020/7/20 17:34
 * author:    Oh_MyBug
 * version:   V1.0
 */

/*
48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class Solution_48 {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix.length;
        int[][] matrix_temp = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrix_temp[i][j] = matrix[i][j];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrix[j][col - 1 - i] = matrix_temp[i][j];
    }

    public static void main(String[] args) {
        Solution_48 solution_48 = new Solution_48();
        int[][] nums = new int[][]{
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        solution_48.rotate(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
