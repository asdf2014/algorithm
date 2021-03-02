import java.util.Arrays;

/**
 * ClassName:   Solution_64
 * Data:        2020/7/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_64 {
//    public int minPathSum(int[][] grid) {
//        if (grid.length == 0) return 0;
//        int m = grid.length;
//        int n = grid[0].length;
//        int dp[][] = new int[m][n];
//        dp[m - 1][n - 1] = grid[m - 1][n - 1];
//        for (int i = m - 2; i >= 0; i--)
//            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n-1];
//        for (int i = n - 2; i >= 0; i--)
//            dp[m - 1][i] = dp[m - 1][i + 1] + grid[m - 1][i];
//        for (int i = m - 2; i >= 0; i--)
//            for (int j = n - 2; j >= 0; j--)
//                dp[i][j] = Math.min(dp[i + 1][j],  dp[i][j+1]) + grid[i][j];
//        return dp[0][0];
//    }

    // 空间优化 DP
    public int minPathSum(int[][] grid) {
        int [] dp = new int[grid[0].length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < grid.length; i++){
            dp[0]=dp[0]+grid[i][0];
            for(int j = 1; j < grid[i].length; j++){
                dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[grid[0].length-1];
    }

    public static void main(String[] args) {
        Solution_64 solution_64 = new Solution_64();
        System.out.println(solution_64.minPathSum(new int[][]{
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}
        }));
    }
}
