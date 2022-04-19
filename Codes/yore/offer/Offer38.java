package com.yore.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/6/22 7:49
 * @description
 */
public class Offer38 {
    List<String> res;

    public String[] permutation(String s) {
        int len = s.length();
        int[] check = new int[len];
        res = new ArrayList<>();

        backtrack(s, check, new StringBuilder(), new HashSet<>());

        String[] result = new String[res.size()];
        int index = 0;

        for (String str : res) {
            result[index++] = str;
        }
        return result;
    }


    public void backtrack(String s, int[] check, StringBuilder sb, Set<Character> set) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (check[i] == 1) {
                continue;
            }
            if (set.contains(s.charAt(i))) {
                continue;
            } else {
                set.add(s.charAt(i));
            }
            sb.append(s.charAt(i));
            check[i] = 1;

            backtrack(s, check, sb, new HashSet<>());

            sb.deleteCharAt(sb.length() - 1);
            check[i] = 0;
        }
    }
}
