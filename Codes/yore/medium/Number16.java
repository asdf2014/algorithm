package com.yore.medium;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/1/25 11:58
 * @description
 */
public class Number16 {
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        if (n == 3) {
            return sum;
        }
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++) {
            for (int second = first + 1; second < n - 1; second++) {
                int third = second + 1;
                while (third <= n - 1) {
                    if (Math.abs(nums[first] + nums[second] + nums[third] - target) < Math.abs(sum - target)) {
                        sum = nums[first] + nums[second] + nums[third];
                    }
                    third++;
                }
            }
        }
        return sum;
    }
}
