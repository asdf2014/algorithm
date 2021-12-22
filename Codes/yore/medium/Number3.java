package com.yore.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2019/1/28
 *
 * @author jiabingwen
 */

public class Number3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("pwwkpaew"));
    }

    /**
     * O(N^2)复杂度
     */
    private static int lengthOfLongestSubstring(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int j = i + 1;
            for (; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    length = length > set.size() ? length : set.size();
                    break;
                } else {
                    set.add(s.charAt(j));
                }
            }
            if (j == s.length()) {
                length = length > set.size() ? length : set.size();
            }
        }
        return length;
    }

    /**
     * 解题思路：
     * 采用集合来存储遍历过程中的单个字符，方便做重复判断：
     * (1)若遍历的字符不在集合中，则将该字符加入集合，并更新最大长度；
     * (2)若在遍历过程中发现当前字符之前出现过，则该字符上次出现位置前的所有数据均失效，需要remove掉；
     * 继续后续字符遍历，直到整个字符串遍历结束
     * （该思路的删除逻辑可以继续优化）
     *
     * @param s 输入字符串
     * @return 最长子串长度
     */
    private static int lengthOfLongestSubstring2(String s) {
        int length = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                length = Math.max(length, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return length;
    }

    /**
     * 解题思路：
     * 关键点，当一个字符在遍历中第二次出现时，表明：
     * 1. 该字符第一次出现位置之前的字符均失效(不计入最大长度统计范围内)
     * 2. 有效字符位从该字符第一词出现位置下一位开始
     * 相对与方案1 减少了遍历次数
     *
     * @param s 输入字符串
     * @return 最大长度
     */
    private static int lengthOfLongestSubstring3(String s) {
        int maxLength = 0;
        int sLength = s.length();
        char character;
        int begin = 0;
        Map<Character, Integer> indexMap = new HashMap<>(sLength);
        for (int i = 0; i < sLength; i++) {
            character = s.charAt(i);
            if (indexMap.containsKey(character) && begin <= indexMap.get(character)) {
                begin = indexMap.get(character) + 1;
            } else {
                maxLength = Math.max(maxLength, i - begin + 1);
            }
            indexMap.put(character, i);
        }
        return maxLength;
    }
}
