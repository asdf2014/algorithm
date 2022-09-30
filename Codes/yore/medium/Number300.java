package com.yore.medium;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/6/9 8:47
 * @description
 */
public class Number300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS_2(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        int res = 0;
        for (int num : nums) {
            int left = 0;
            int right = res;
            while (left < right) {
                int m = left + ((right - left) >> 1);
                if (d[m] < num) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }
            d[right] = num;
            if (res == right) {
                res++;
            }
        }
        return res;
    }

}
