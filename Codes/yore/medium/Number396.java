package com.yore.medium;

/**
 * @author Yore
 * @date 2022/4/22 9:02
 * @description
 */
public class Number396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int res = 0;
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            res += i * nums[i];
        }
        int base = res;
        for (int i = 1; i < n; i++) {
            base = base - prefix + n * nums[i - 1];
            res = Math.max(res, base);
        }
        return res;
    }
}
