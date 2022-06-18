package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/24 10:30
 * @description
 */
public class Number213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(process(nums, 0, n - 2), process(nums, 1, n - 1));
    }

    public int process(int[] nums, int begin, int end) {
        int pre = nums[begin];
        int cur = Math.max(nums[begin], nums[begin + 1]);
        int tmp;
        for (int i = begin + 2; i <= end; i++) {
            tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;
        }
        return cur;
    }
}
