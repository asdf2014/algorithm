package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/6/23 8:40
 * @description
 */
public class Number438 {

    public static void main(String[] args) {
        Number438 n = new Number438();
        System.out.println(n.findAnagrams("cbaebabacd","abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[26];
        int[] target = new int[26];
        int n = p.length();
        for (int i = 0; i < n; i++) {
            target[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            cnt[s.charAt(right) - 'a']++;
            if (right - left == n-1) {
                int i = 0;
                for (; i < 26; i++) {
                    if (target[i] != cnt[i]) {
                        break;
                    }
                }
                if (i == 26) {
                    res.add(left);
                }
                cnt[s.charAt(left++) - 'a']--;
            }
            right++;
        }
        return res;
    }
}
