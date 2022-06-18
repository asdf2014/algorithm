package com.yore.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/2/24 10:46
 * @description
 */
public class Offer017 {
    public static void main(String[] args) {
        String a = "";

    }

    public String minWindow(String s, String t) {
        String result = "";
        int len1 = s.length();
        int len2 = t.length();
        Map<Character, Integer> freqs = new HashMap<>();
        Map<Character, Integer> freqt = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            char c = t.charAt(i);
            freqt.put(c, freqt.getOrDefault(c, 0) + 1);
        }
        int cnt = 0;
        int left = 0;
        for (int right = 0; right < len1; right++) {
            char c = s.charAt(right);
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
            if (freqs.get(c) <= freqt.getOrDefault(c, 0)) {
                cnt++;
            }
            // c = s.charAt(left);
            while (left < right && freqs.get(s.charAt(left)) > freqt.getOrDefault(s.charAt(left), 0)) {
                freqs.put(s.charAt(left), freqs.get(s.charAt(left)) - 1);
                left++;
            }
            if (cnt == t.length()) {
                if ("".equals(result) || result.length() > (right - left + 1)) {
                    result = s.substring(left, right + 1);
                }
            }
        }
        return result;
    }
}
