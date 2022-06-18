package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/21 10:20
 * @description
 */
public class Offer14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * (dp[i - j])));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Offer14_1 o = new Offer14_1();
        System.out.println(o.cuttingRope(2));
    }
}
