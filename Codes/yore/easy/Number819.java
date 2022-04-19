package com.yore.easy;

import java.util.*;

/**
 * @author Yore
 * @date 2022/4/17 9:21
 * @description
 */
public class Number819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if (Character.isLetter(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (sb.length() > 0) {
                String word = sb.toString();
                if (!ban.contains(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                }
                sb = new StringBuilder("");
            }
        }
        int max = 0;
        String res = "";
        for (String word : count.keySet()) {
            if (count.get(word) > max) {
                max = count.get(word);
                res = word;
            }
        }
        return res;
    }
}
