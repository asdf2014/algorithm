package com.yore.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jia bing wen
 * @date 2021/5/26 15:47
 * @description
 */
public class Number242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list1.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            list2.add(t.charAt(i));
        }
        Collections.sort(list1);
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a'] += 1;
            array[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
