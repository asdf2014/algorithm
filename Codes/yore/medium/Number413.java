package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/27 9:00
 * @description
 */
public class Number413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int d = nums[1] - nums[0];
        int ans = 0;
        int t = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == d) {
                t++;
            } else {
                d = nums[i] - nums[i - 1];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}
