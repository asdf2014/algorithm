package com.yore.easy;

/**
 * @author Yore
 * @date 2022/2/20 10:06
 * @description
 */
public class Number717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i += 1;
            }
        }
        return false;
    }
}
