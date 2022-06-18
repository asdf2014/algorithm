package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/28 21:55
 * @description
 */
public class Number152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxMulti = nums[0];
        int minMulti = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = maxMulti, mn = minMulti;
            maxMulti = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minMulti = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            max = Math.max(max, maxMulti);
        }
        return max;
    }
}
