package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/1/18 15:12
 * @description
 */
public class Offer009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int multi = 1;
            int r = i;
            while (r < nums.length) {
                multi *= nums[r];
                if (multi < k) {
                    count++;
                    r++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int multi = 1;
        for (int right = 0; right < nums.length; right++) {
            multi *= nums[right];
            while (left <= right && multi >= k) {
                multi /= nums[left++];
            }
            count += right >= left ? (right - left + 1) : 0;
        }
        return count;
    }
}
