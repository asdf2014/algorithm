package com.yore.medium;

/**
 * @author Yore
 * @date 2022/4/23 9:51
 * @description
 */
public class Number75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }
}
