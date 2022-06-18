package com.yore.easy;

/**
 * @author Yore
 * @date 2022/1/22 10:53
 * @description
 */
public class Number1332 {
    public int removePalindromeSub(String s) {
        int len = s.length();
        int right = len / 2;
        int left = len % 2 == 0 ? right - 1 : right;
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                return 2;
            }
        }
        return 1;
    }
}
