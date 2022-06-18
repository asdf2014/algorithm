package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/1/21 15:44
 * @description
 */
public class Offer008 {

    public static void main(String[] args) {
        Offer008 o = new Offer008();
        System.out.println(o.minSubArrayLen(6, new int[]{10, 2, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (dp[0] >= target) {
            min = 1;
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + nums[i];
            if (dp[i] >= target && min == Integer.MAX_VALUE) {
                min = i + 1;
            }
            while (dp[i] - dp[left] >= target) {
                left++;
                min = Math.min(min, i - left + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
