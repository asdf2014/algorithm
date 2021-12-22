package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/5/16 8:31
 * @description
 */
public class Number421 {

    /**
     * n^2复杂度
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    public int findMaximumXOR1(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = -1;

        return max;
    }
}
