package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/28 16:58
 * @description
 */
public class Offer033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(strs[0]);
        boolean process = false;
        for (int i = 1; i < len; i++) {
            process = false;
            for (List<String> list : result) {
                int[] freq = new int[26];
                String a = list.get(0);
                if (a.length() != strs[i].length()) {
                    continue;
                }
                for (int k = 0; k < a.length(); k++) {
                    freq[a.charAt(k) - 'a']++;
                    freq[strs[i].charAt(k) - 'a']--;
                }
                int j = 0;
                for (; j < 26; j++) {
                    if (freq[j] != 0) {
                        break;
                    }
                }
                if (j == 26) {
                    list.add(strs[i]);
                    process = true;
                    break;
                }
            }
            if (!process) {
                List<String> t = new ArrayList<>();
                t.add(strs[i]);
                result.add(t);
            }
        }
        return result;
    }
}
