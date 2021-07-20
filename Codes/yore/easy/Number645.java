package com.yore.easy;

/**
 * @author jia bing wen
 * @date 2021/7/4 11:56
 * @description
 */
public class Number645 {
    public int[] findErrorNums(int[] nums) {
        int[] contain = new int[nums.length + 1];
        int[] result = new int[2];
        for (int num : nums) {
            if (contain[num] == 1) {
                result[0] = num;
            }
            contain[num] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (contain[i] == 0) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
