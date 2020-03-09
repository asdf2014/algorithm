# 执行用时 : 44 ms
# 内存消耗 : 14.5 MB

# 方案： https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        # base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        dp_i_0 = 0
        dp_i_1 = -9999999
        for i in range(n):
            # dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            # dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = max(dp_i_1, -prices[i])
        return dp_i_0
