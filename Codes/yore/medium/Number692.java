package com.yore.medium;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/5/20 8:21
 * @description
 */
public class Number692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return map.get(word1).equals(map.get(word2)) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
            }
        });
        return list.subList(0, k);
    }
}
