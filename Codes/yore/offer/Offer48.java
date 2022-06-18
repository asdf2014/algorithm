package com.yore.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/7/6 10:16
 * @description
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        String[] dp = new String[s.length()];
        dp[0] = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!dp[i - 1].contains(String.valueOf(s.charAt(i)))) {
                dp[i] = dp[i - 1] + s.charAt(i);
            } else {
                Set<Character> set = new HashSet<>();
                int j = i;
                while (j >= 0 && !set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    j--;
                }
                dp[i] = s.substring(j + 1, i + 1);
            }
        }
        int max = 0;
        for (String value : dp) {
            max = Math.max(max, value.length());
        }
        return max;
    }


    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

}
