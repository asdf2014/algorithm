package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/2 10:23
 * @description
 */
public class Offer53_2 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid;
            }
        }
        return left;
    }

}
