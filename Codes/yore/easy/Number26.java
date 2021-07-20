package com.yore.easy;

/**
 * Created on 2019/1/29
 *
 * @author jiabingwen
 */

public class Number26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int i = 0, j = 0;
        while (j < length - 1) {
            if (nums[j] != nums[++j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
