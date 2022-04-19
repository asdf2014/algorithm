package com.yore.offer2;

import java.util.List;

/**
 * @author Yore
 * @date 2022/3/15 9:15
 * @description
 */
public class Offer100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            if (i == n - 1) {
                for (int idx = 0; idx < list.size(); idx++) {
                    dp[idx] = list.get(idx);
                }
            } else {
                for (int idx = 0; idx < list.size(); idx++) {
                    dp[idx] = list.get(idx) + Math.min(dp[idx + 1], dp[idx]);
                }
            }
        }
        return dp[0];
    }
}
