package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/5/28 7:53
 * @description
 */
public class Number477 {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return sum;
    }
}
