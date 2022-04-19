package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/26 10:08
 * @description
 */
public class Number918 {
    public static void main(String[] args) {
        Number918 n = new Number918();
        System.out.println(n.maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalNum = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            max = Math.max(max, maxSum);
            minSum = Math.min(minSum + nums[i], nums[i]);
            min = Math.min(min, minSum);
            totalNum += nums[i];
        }
        return max > 0 ? Math.max(max, totalNum - min) : max;
    }
}
