package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/24 15:24
 * @description
 */
public class Number122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > cur) {
                profit += (prices[i] - cur);
            }
            cur = prices[i];
        }
        return profit;
    }
}
