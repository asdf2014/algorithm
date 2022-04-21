package com.yore.medium;

import java.util.*;

/**
 * @author Yore
 * @date 2022/4/21 10:03
 * @description
 */
public class Number49 {
    public static void main(String[] args) {
        Number49 number49 = new Number49();
        System.out.println(number49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * 单词排序
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] charry = word.toCharArray();
            Arrays.sort(charry);
            String key = new String(charry);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams_1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;
        if (n <= 0) {
            return res;
        }
        List<int[]> record = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = strs[i];
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            int j = 0;
            for (; j < res.size(); j++) {
                int[] mem = record.get(j);
                int k = 0;
                for (; k < 26; k++) {
                    if (count[k] != mem[k]) {
                        break;
                    }
                }
                if (k == 26) {
                    res.get(j).add(word);
                    break;
                }
            }
            if (j == res.size()) {
                List<String> t = new ArrayList<>();
                t.add(word);
                res.add(t);
                record.add(count);
            }
        }
        return res;
    }
}
