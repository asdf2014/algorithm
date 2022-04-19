package com.yore.medium;

import java.util.List;

/**
 * @author Yore
 * @date 2022/3/2 8:39
 * @description
 */
public class Number120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int index = 1;
        for (int k = 1; k < triangle.size(); k++) {
            List<Integer> list = triangle.get(k);
            int len = list.size();
            for (int i = 0; i < len; i++) {
                if (i == len - 1) {
                    dp[index][i] = dp[index - 1][i - 1] + list.get(i);
                } else {
                    dp[index][i] = dp[index - 1][i] + list.get(i);
                    if (i > 0) {
                        dp[index][i] = Math.min(dp[index][i], dp[index - 1][i - 1] + list.get(i));
                    }
                }
            }
            index++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}
