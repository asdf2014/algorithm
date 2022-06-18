package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/25 10:46
 * @description
 */
public class Number55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightBound = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightBound) {
                rightBound = Math.max(rightBound, i + nums[i]);
                if (rightBound >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
