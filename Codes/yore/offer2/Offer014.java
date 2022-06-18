package com.yore.offer2;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/2/24 8:28
 * @description
 */
public class Offer014 {
    public static void main(String[] args) {
        Offer014 o = new Offer014();
        System.out.println(o.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 < len1) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq1, freq2)) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }
        return false;
    }
}
