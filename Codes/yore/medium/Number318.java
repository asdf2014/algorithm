package com.yore.medium;

/**
 * @author Yore
 * @date 2021/11/17 10:54
 * @description
 */
public class Number318 {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int l = word.length();
            for (int j = 0; j < l; j++) {
                mask[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
