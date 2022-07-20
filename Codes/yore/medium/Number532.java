package com.yore.medium;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/6/17 8:47
 * @description
 */
public class Number532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int right = 0;
        int n = nums.length;
        int count = 0;
        for (int left = 0; left < n; left++) {
            if (left == 0 || nums[left] != nums[left - 1]) {
                while (right < n && (nums[right] < nums[left] + k || right <= left)) {
                    right++;
                }
                if (right < n && nums[right] == nums[left] + k) {
                    count++;
                }
            }
        }
        return count;
    }
}
