package com.yore.easy;

/**
 * @author Yore
 * @date 2022/2/24 15:15
 * @description
 */
public class Number121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minIdx = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - prices[minIdx]);
            minIdx = prices[i] < prices[minIdx] ? i : minIdx;
        }
        return profit;
    }
}
