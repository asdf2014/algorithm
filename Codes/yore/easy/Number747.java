package com.yore.easy;

/**
 * @author Yore
 * @date 2022/1/13 14:55
 * @description
 */
public class Number747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = -1;
        int second = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        if (max >= (second * 2)) {
            return index;
        }
        return -1;
    }
}
