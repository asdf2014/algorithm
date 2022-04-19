package com.yore.medium;

/**
 * @author Yore
 * @date 2021/11/8 21:08
 * @description
 */
public class Number260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor == Integer.MIN_VALUE ? xor : xor & (-xor);
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
