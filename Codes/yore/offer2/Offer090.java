package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/13 9:51
 * @description
 */
public class Offer090 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    public int helper(int[] nums, int begin, int end) {
        int first = nums[begin];
        int second = Math.max(nums[begin], nums[begin + 1]);
        for (int i = begin + 2; i <= end; i++) {
            int tmp = Math.max(first + nums[i], second);
            first = second;
            second = tmp;
        }
        return second;
    }
}
