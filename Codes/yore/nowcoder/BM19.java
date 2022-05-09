package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/5/3 10:51
 * @description
 */
public class BM19 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
