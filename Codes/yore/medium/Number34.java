package com.yore.medium;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2021/12/29 9:27
 * @description
 */
public class Number34 {
    public static void main(String[] args) {
        Number34 number34 = new Number34();
        int[] res = number34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(res));
    }

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        if(nums == null || nums.length<1){
            return res;
        }
        res[0] = leftBounds(nums, target);
        res[1] = rightBounds(nums, target);
        return res;
    }

    public int leftBounds(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left >=nums.length || nums[left]!=target){
            return -1;
        }
        return left;
    }

    public int rightBounds(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(right <0 || nums[right]!=target){
            return -1;
        }
        return right;
    }
}
