package com.yore.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2021/10/9 15:56
 * @description
 */
public class Number76 {

    public String minWindow(String s, String t) {
        String target = "";
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            // 增加窗口
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            // 满足条件后开始缩小窗口
            if (valid == need.size()) {
                while (left < right) {
                    char slider = s.charAt(left);
                    if (!window.containsKey(slider)) {
                        left++;
                    } else if (window.containsKey(slider) && window.get(slider) > need.get(slider)) {
                        left++;
                        window.put(slider, window.get(slider) - 1);
                    } else {
                        break;
                    }
                }
                if ("".equals(target) || s.substring(left, right).length() < target.length()) {
                    target = s.substring(left, right);
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        Number76 number76 = new Number76();
        System.out.println(number76.minWindow("AA", "AA"));
    }
}
