package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/4/28 14:37
 * @description   平方数之和
 */
public class Number633 {
    public static void main(String[] args) {

    }

    public boolean judgeSquareSum(int c){
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
