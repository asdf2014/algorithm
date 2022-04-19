package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/1/22 17:16
 * @description
 */
public class Offer020 {
    public int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count++;
            process(s, i - 1, i + 1);
            process(s, i, i + 1);
        }
        return count;
    }

    public void process(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            } else {
                return;
            }
        }
    }
}
