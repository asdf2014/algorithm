package com.yore.easy;

/**
 * @author Yore
 * @date 2021/12/29 9:15
 * @description
 */
public class Number69 {
    public int mySqrt(int x) {
        int ans = -1;
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
