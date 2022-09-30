package com.yore.hard;

/**
 * @author Yore
 * @date 2022/7/12 10:01
 * @description
 */
public class Number123 {
    public static void main(String[] args) {
        Number123 number123 = new Number123();
        System.out.println(number123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0];
        int sale1 = 0;
        int buy2 = -prices[0];
        int sale2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sale1 = Math.max(sale1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sale1 - prices[i]);
            sale2 = Math.max(sale2, buy2 + prices[i]);
        }
        return sale2;
    }
}
