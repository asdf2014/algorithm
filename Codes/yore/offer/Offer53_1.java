package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/7/2 9:05
 * @description
 */
public class Offer53_1 {
    public int search(int[] nums, int target) {
//        int count = 0;
//        for (int num : nums) {
//            if (num == target) {
//                count++;
//            } else if (num > target) {
//                return count;
//            }
//        }
//        return count;
        return seek(nums, target) - seek(nums, target - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 7, 8, 8, 9};
        int target = 1;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    public int seek(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
