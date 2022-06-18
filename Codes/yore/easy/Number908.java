package com.yore.easy;

/**
 * @author Yore
 * @date 2022/4/30 9:00
 * @description
 */
public class Number908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = 100001;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int val = max - min;
        return val <= k * 2 ? 0 : val - k * 2;
    }
}
