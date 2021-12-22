package com.yore.medium;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/7/20 8:24
 * @description
 */
public class Number1877 {
    public int minPairSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int index = length / 2;
        int minSum = 0;
        for (int i = 0; i < index; i++) {
            minSum = Math.max(minSum, nums[i] + nums[length - 1 - i]);
        }
        return minSum;
    }
}
