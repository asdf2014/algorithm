package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/25 8:29
 * @description
 */
public class Number309 {
    public int money = 0;

    public int maxProfit(int[] prices) {
        process(prices, 0, 1, 0);
        return money;
    }

    public void process(int[] prices, int buy, int index, int profit) {
        if (index >= prices.length) {
            money = Math.max(money, profit);
            return;
        }
        if (prices[index] < prices[buy]) {
            process(prices, index, index + 1, profit);
        } else {
            process(prices, index + 2, index + 3, profit + (prices[index] - prices[buy]));
            process(prices, buy, index + 1, profit);
        }
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }


}
