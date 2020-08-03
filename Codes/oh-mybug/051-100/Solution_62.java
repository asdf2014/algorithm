import java.util.Arrays;

/**
 * ClassName:   Solution_62
 * Data:        2020/7/24
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
示例 1:
输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:
输入: m = 7, n = 3
输出: 28
 */
public class Solution_62 {
    // O(m*n)空间复杂度 DP
    public int uniquePaths_DP(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];	// 创建数组进行记录
        // 初始化条件1，当机器人从 (0,0) 到第一列的任何一个位置，都只有一条路（一直向下）
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        // 初始化条件2，当机器人从 (0,0) 到第一行的任何一个位置，都只有一条路（一直向右）
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        // 方程 f(i, j) = f(i - 1, j) + f(i, j - 1)
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }

    // O(2*n) 空间复杂度DP
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);    // 填充为1
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++)
                cur[j] = cur[j-1] + pre[j];
            pre = cur.clone();  // 当前cur值赋给pre
        }
        return pre[n-1];
    }


    // 动态规划、优化空间O(n)
    /*public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);         // 填充数组
        for (int i = 1; i < m;i++)
            for (int j = 1; j < n; j++)
                cur[j] += cur[j-1] ;    // 累加
        return cur[n-1];
    }*/

   public int uniquePaths_DFS(int m, int n) {
        // 用数组的原因是数组作为引用地址不变
        // 另一种方法是将 res 作为实例变量即可用 int 型
        int[] res = new int[]{0};
        dfs(m, n, 0, 0, res);
        return res[0];
    }

    public void dfs(int m, int n, int m_i, int n_i, int[] res){
        if (m - 1 == m_i && n - 1 == n_i) { // 到叶子节点
            ++ res[0];  // 计数
            return;
        }
        if (m - 1 > m_i)    // 在下边界内，防止越界
            dfs(m, n, m_i + 1, n_i, res);
        if (n - 1 > n_i)    // 在右边界内，防止越界
            dfs(m, n, m_i, n_i + 1, res);
    }

    public static void main(String[] args) {
        Solution_62 solution_62 = new Solution_62();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            solution_62.uniquePaths_DP(10, 10);
        }
        end = System.currentTimeMillis();
        System.out.println("DP RunTime: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            solution_62.uniquePaths_DFS(10, 10);
        }
        end = System.currentTimeMillis();
        System.out.println("DFS RunTime: " + (end - start));
    }
}
