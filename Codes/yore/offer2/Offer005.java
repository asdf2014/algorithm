package com.yore.offer2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yore
 * @date 2022/1/18 15:51
 * @description
 */
public class Offer005 {

    public int maxProduct(String[] words) {
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int idx = 0; idx < words[i].length(); idx++) {
                set.add(words[i].charAt(idx));
            }
            for (int j = i + 1; j < words.length; j++) {
                if (!match(set, words[j])) {
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        return maxLen;
    }

    public boolean match(Set<Character> set, String b) {
        for (int j = 0; j < b.length(); j++) {
            if (set.contains(b.charAt(j))) {
                return true;
            }
        }
        return false;
    }
}
