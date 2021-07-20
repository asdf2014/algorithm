package com.yore.easy;

/**
 * Created on 2019/1/29
 *
 * @author jiabingwen
 */

public class Number35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;

    }
}
