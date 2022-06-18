package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/9 9:19
 * @description
 */
public class Offer42 {
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int res = pre;
        int current;
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(pre + nums[i], nums[i]);
            pre = current;
            res = Math.max(res, current);
        }
        return res;
    }
}
