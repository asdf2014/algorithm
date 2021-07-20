package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/7 8:25
 * @description
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int max = prices[len - 1];
        int profit = 0;
        for (int i = len - 2; i >= 0; i--) {
            profit = Math.max(profit,max-prices[i]);
            max = Math.max(max,prices[i]);
        }
        return profit;
    }
}
