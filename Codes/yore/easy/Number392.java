package com.yore.easy;

/**
 * @author Yore
 * @date 2022/1/14 16:41
 * @description
 */
public class Number392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(count) == t.charAt(i)) {
                count++;
            }
            if (count == s.length()) {
                return true;
            }
        }
        return false;
    }
}
