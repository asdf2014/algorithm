package com.yore.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/1/20 20:24
 * @description
 */
public class Offer034 {
    public static void main(String[] args) {
        Offer034 o = new Offer034();
        System.out.println(o.isAlienSorted(new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!cmp(words[i - 1], words[i], indexMap)) {
                return false;
            }
        }
        return true;
    }

    public boolean cmp(String a, String b, Map<Character, Integer> indexMap) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            char a_c = a.charAt(i);
            char b_c = b.charAt(j);
            if (a_c != b_c) {
                return indexMap.get(a_c) < indexMap.get(b_c);
            } else {
                i++;
                j++;
            }
        }
        return i == a.length();
    }
}
