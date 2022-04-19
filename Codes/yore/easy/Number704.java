package com.yore.easy;

/**
 * @author Yore
 * @date 2021/12/28 11:16
 * @description
 */
public class Number704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return -1;
    }
}
