package com.yore.medium;

/**
 * @author Yore
 * @date 2022/2/24 21:57
 * @description
 */
public class Number80 {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int pre = nums[0];
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[idx++] = nums[i];
                pre = nums[i];
                cnt = 1;
            } else {
                if (cnt < 2) {
                    cnt++;
                    nums[idx++] = nums[i];
                }
            }
        }
        return idx;
    }
}
