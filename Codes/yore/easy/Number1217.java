package com.yore.easy;

/**
 * @author Yore
 * @date 2022/7/8 9:54
 * @description
 */
public class Number1217 {
    public int minCostToMoveChips(int[] position) {
        int oddValue = 0;
        int evenValue = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                oddValue++;
            } else {
                evenValue++;
            }
        }
        return Math.min(oddValue, evenValue);
    }
}
