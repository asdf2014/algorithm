package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/24 8:35
 * @description
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int end = 0;
        while (end < nums.length && nums[end] < target) {
            end++;
        }
        end--;
        int begin = 0;
        while (begin < end) {
            int sum = nums[begin] + nums[end];
            if (sum < target) {
                begin++;
            } else if (sum == target) {
                return new int[]{nums[begin], nums[end]};
            } else {
                end--;
            }
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) {
                i++;
            } else if (s > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        Offer57 o = new Offer57();
        System.out.println(o.twoSum(new int[]{2, 7, 11, 15}, 9));

    }
}
