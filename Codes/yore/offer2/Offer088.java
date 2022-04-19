package com.yore.offer2;

/**
 * @author Yore
 * @date 2021/11/10 8:42
 * @description
 */
public class Offer088 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }

        return Math.min(dp[cost.length-2],dp[cost.length-1]);
    }
}
