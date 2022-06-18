package com.yore.offer2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yore
 * @date 2022/3/8 9:37
 * @description
 */
public class Offer065 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String str : set) {
            ans += (str.length() + 1);
        }
        return ans;
    }
}
