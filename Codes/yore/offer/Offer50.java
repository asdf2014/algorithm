package com.yore.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/5/28 15:30
 * @description
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        Set<Character> repeat = new HashSet<>();
        Set<Character> once = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (repeat.contains(s.charAt(i))) {
                continue;
            }
            if (once.contains(s.charAt(i))) {
                repeat.add(s.charAt(i));
                once.remove(s.charAt(i));
            } else {
                once.add(s.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (once.contains(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return ' ';
    }


    public char firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
