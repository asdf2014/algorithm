/**
 * ClassName:   Solution_70
 * Data:        2020/7/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_70 {
    // DP
    /*public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n-1];
    }*/

    // 空间优化后的 DP
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int dp1 = 1;
        int dp2 = 2;
        for (int i = 2; i < n; i++){
            int temp = dp1 + dp2;
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;
    }

    // 递归
//    public int climbStairs(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    public static void main(String[] args) {
        System.out.println(new Solution_70().climbStairs(5));
    }
}
