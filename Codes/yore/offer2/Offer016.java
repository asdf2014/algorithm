package com.yore.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/2/21 10:29
 * @description
 */
public class Offer016 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aa"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int begin = 0;
        int maxLen = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (idxMap.containsKey(c) && idxMap.get(c) >= begin) {
                begin = idxMap.get(c) + 1;
            } else {
                maxLen = Math.max(maxLen, i - begin + 1);
            }
            idxMap.put(c, i);
        }
        return maxLen;
    }
}
