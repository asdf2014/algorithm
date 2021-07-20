package com.yore.easy;

/**
 * @author yore
 * @date 2020/11/8 20:44
 * @description
 */
public class Number122 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
}
