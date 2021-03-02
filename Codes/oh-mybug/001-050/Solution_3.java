import java.util.*;

/**
 * ClassName:   Solution_
 * Data:        2020/7/11
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        return helper(s);
    }

    // 核心函数 示例：“pwwkew”
    public static int helper(String s){
        char[] ch = s.toCharArray();
        List<Character> list = new LinkedList<>();
        int max = 0;
        // 循环遍历字符串的所有字符
        for (char c : ch){
            if (list.contains(c)){          // 如果list中已有字符c
                // 移除list中已有字符c之前（包括字符c）的所有字符
                while (list.get(0) != c)
                    list.remove(0);
                list.remove(0);
            }
            // 添加字符c
            list.add(c);
            // 每次添加字符都更新最大值
            max = Math.max(list.size(), max);
        }
        return max;
    }
}
