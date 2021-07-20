package com.yore.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/7/5 8:22
 * @description
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if (repeat.contains(nums[i])) {
                return false;
            }
            repeat.add(nums[i]);
        }
        return max - min < 5;
    }
}
