package com.yore.easy;

/**
 * @author Yore
 * @date 2022/5/28 10:59
 * @description
 */
public class Number1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int left = 0;
        int cnt = 1;
        int right = 1;
        while (right < len) {
            char ch = s.charAt(right);
            if (ch == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                sb.append(s.substring(left + 1, right));
                left = right + 1;
                right += 2;
                cnt = 1;
            } else {
                right++;
            }

        }
        return sb.toString();
    }
}
