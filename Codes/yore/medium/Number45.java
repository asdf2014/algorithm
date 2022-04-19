package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/25 10:46
 * @description
 */
public class Number45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxPos = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }
}
