package com.yore.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/24 9:55
 * @description
 */
public class Offer015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int len1 = s.length();
        int len2 = p.length();
        if (len1 < len2) {
            return res;
        }
        for (int i = 0; i < len2; i++) {
            freq1[s.charAt(i) - 'a']++;
            freq2[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq1, freq2)) {
            res.add(0);
        }
        for (int i = len2; i < len1; i++) {
            freq1[s.charAt(i) - 'a']++;
            freq1[s.charAt(i - len2) - 'a']--;
            if (Arrays.equals(freq1, freq2)) {
                res.add(i - len2 + 1);
            }
        }
        return res;
    }
}
