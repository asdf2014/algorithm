import java.util.Arrays;

/**
 * ClassName:   Solution_59
 * Data:        2020/7/27
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
示例:
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = 0, col = 0;
        int cur = 1;
        while (cur <= n * n) {
            while (col < n && res[row][col] == 0) res[row][col ++] = cur ++;
            row++; col--;
            while (row < n && res[row][col] == 0) res[row ++][col] = cur ++;
            row--; col--;
            while (col >= 0 && res[row][col] == 0) res[row][col --] = cur ++;
            row--; col++;
            while (row >= 0 && res[row][col] == 0) res[row --][col] = cur ++;
            row++; col++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_59 solution_59 = new Solution_59();
        Arrays.asList(solution_59.generateMatrix(0)).forEach(r->{
            System.out.println(Arrays.toString(r));
        });
    }
}
