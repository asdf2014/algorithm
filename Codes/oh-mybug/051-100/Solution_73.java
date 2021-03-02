import java.util.Arrays;

/**
 * ClassName:   Solution_73
 * Data:        2020/7/28
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
73. 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

 */
public class Solution_73 {
    // O(m*n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m*n];
        int[] cols = new int[m*n];
        int size = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    rows[size] = i;
                    cols[size] = j;
                    size ++;
                }
            }
        }

        for (int i = 0; i < size; i++)
            for (int j = 0; j < n; j++)
                matrix[rows[i]][j] = 0;

        for (int i = 0; i < size; i++)
            for (int j = 0; j < m; j++)
                matrix[j][cols[i]] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        Solution_73 solution_73 = new Solution_73();
        solution_73.setZeroes(matrix);
        Arrays.asList(matrix).forEach(m->{
            System.out.println(Arrays.toString(m));
        });
    }

    /*
      {0,1,2,0},
      {3,4,5,2},
      {1,3,1,5}

        {1,1,1},
        {1,0,1},
        {1,1,1}
     */
}
