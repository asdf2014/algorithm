package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/1/21 16:58
 * @description
 */
public class Offer018 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        char a;
        char c;
        while (left <= right) {
            a = ' ';
            c = ' ';
            while (c == ' ' && left <s.length()) {
                if ((s.charAt(left) >= 48 && s.charAt(left) <= 57) || (s.charAt(left) >= 97 && s.charAt(left) <= 122)) {
                    c = s.charAt(left);
                } else if ((s.charAt(left) >= 65 && s.charAt(left) <= 90)) {
                    c = s.charAt(left);
                    c += 32;
                } else {
                    left++;
                }
            }
            while (a == ' ' && right>=0) {
                if ((s.charAt(right) >= 48 && s.charAt(right) <= 57) || (s.charAt(right) >= 97 && s.charAt(right) <= 122)) {
                    a = s.charAt(right);
                } else if ((s.charAt(right) >= 65 && s.charAt(right) <= 90)) {
                    a = s.charAt(right);
                    a += 32;
                } else {
                    right--;
                }
            }
            if (a != c) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
