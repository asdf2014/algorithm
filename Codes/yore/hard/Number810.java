package com.yore.hard;

/**
 * @author jia bing wen
 * @date 2021/5/22 8:57
 * @description
 */
public class Number810 {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res == 0;
    }


}
