package com.yore.medium;

/**
 * @author Yore
 * @date 2022/5/5 11:01
 * @description
 */
public class Number713 {
    public static void main(String[] args) {
        Number713 n = new Number713();
//        System.out.println(n.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(n.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 1;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum *= nums[right];
            while (left <= right && sum >= k) {
                sum /= nums[left++];
            }
            count += (right - left + 1);
        }
        return count;
    }
}
