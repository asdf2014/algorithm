package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/24 10:53
 * @description
 */
public class Number740 {
    public int deleteAndEarn(int[] nums) {
        int maxValue = -1;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] sum = new int[maxValue + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = second;
            second = Math.max(second, first + nums[i]);
            first = tmp;
        }
        return second;
    }
}
