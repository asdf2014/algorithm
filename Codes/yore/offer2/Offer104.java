package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/16 8:36
 * @description
 */
public class Offer104 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int num : nums) {
                if (j - num >= 0) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }
}
