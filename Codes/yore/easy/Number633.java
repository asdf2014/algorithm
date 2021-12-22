package com.yore.easy;

/**
 * Created on 2019/1/27
 * 平方数之和
 *
 * @author jiabingwen
 */

public class Number633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(999999999));
    }

    public static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);
        int temp = 0;
        while (left <= right) {
            temp = left * left + right * right;
            if (temp < c) {
                left++;
            } else if (temp == c) {
                return true;
            } else {
                right--;
            }
        }
        return false;
    }
}
