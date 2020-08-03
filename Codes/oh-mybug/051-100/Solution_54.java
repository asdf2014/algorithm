import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_54
 * Data:        2020/7/21
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution_54 {
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//        if (matrix.length == 0) return res;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int round = 0;
//        while (res.size() != m * n){
//            round(matrix, res, round, matrix.length - round, round, matrix[0].length - round);
//            round ++;
//        }
//        return res;
//    }
//
//    public void round(int[][] matrix, List<Integer> res, int m_start, int m_end, int n_start, int n_end){
//        int row, col;
//        if (m_start == m_end - 1){
//            row = m_start; col = n_start;
//            while (col <= n_end - 1){
//                res.add(matrix[row][col]);
//                col ++;
//            }
//            return;
//        }else if(n_start == n_end - 1){
//            row = m_start; col = n_end - 1;
//            while (row <= m_end - 1){
//                res.add(matrix[row][col]);
//                row ++;
//            }
//            return;
//        }
//        row = m_start; col = n_start;
//        while (col < n_end - 1){
//            res.add(matrix[row][col]);
//            col ++;
//        }
//        row = m_start; col = n_end - 1;
//        while (row < m_end - 1){
//            res.add(matrix[row][col]);
//            row ++;
//        }
//        row = m_end - 1; col = n_end - 1;
//        while (col > n_start){
//            res.add(matrix[row][col]);
//            col --;
//        }
//        row = m_end - 1; col = n_start;
//        while (row > m_start){
//            res.add(matrix[row][col]);
//            row --;
//        }
//    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++)
                order.add(matrix[top][column]);
            for (int row = top + 1; row <= bottom; row++)
                order.add(matrix[row][right]);
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--)
                    order.add(matrix[bottom][column]);
                for (int row = bottom; row > top; row--)
                    order.add(matrix[row][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        Solution_54 solution_54 = new Solution_54();
        System.out.println(solution_54.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
        }).toString());

    }
    /*
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]

     [1, 2, 3, 4],
     [5, 6, 7, 8],
     [9,10,11,12]
     */
}
