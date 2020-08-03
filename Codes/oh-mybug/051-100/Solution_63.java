import java.util.Arrays;

/**
 * ClassName:   Solution_63
 * Data:        2020/7/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。
说明：m 和 n 的值均不超过 100。
示例 1:
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Solution_63 {
    public static void main(String[] args) {
        Solution_63 solution_63 = new Solution_63();
        System.out.println(solution_63.uniquePathsWithObstacles(new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }

    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }*/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,
                n = obstacleGrid[0].length;
        if (m == 0 || n == 0) return 0;
        int[][] res = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            if (i == m - 1)
                res[i][n - 1] = obstacleGrid[i][n - 1] == 1 ? 0 : 1;
            else
                res[i][n - 1] = obstacleGrid[i][n - 1] == 1 ? 0 : res[i + 1][n - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1)
                res[m - 1][i] = obstacleGrid[m - 1][i] == 1 ? 0 : 1;
            else
                res[m - 1][i] = obstacleGrid[m - 1][i] == 1 ? 0 : res[m - 1][i + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1)
                    res[i][j] = 0;
                else
                    res[i][j] = res[i + 1][j] + res[i][j + 1];
            }
        }
        Arrays.asList(res).forEach(list->{
            System.out.println(Arrays.toString(list));
        });
        return res[0][0];
    }
}
