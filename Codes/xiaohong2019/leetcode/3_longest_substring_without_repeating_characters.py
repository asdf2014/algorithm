# -*- coding: utf-8 -*-
# URL : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

""""""

"""
problem:
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
"""

"""
explain:
由于这里是子串，所以可以用 start、end 来表示当前子串。
如果发生重复字符，先算出长度，即 end - start + 1，
再调整 start 位置为重复字符在子串的位置，调整 end 为当前遍历位置，再进入下一个循环。
"""

"""
out:
执行用时 : 76 ms, 在所有 python3 提交中击败了 63.31% 的用户
内存消耗 : 12.6 MB, 在所有 python3 提交中击败了 99.68% 的用户
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # check boundary
        length = len(s)
        if length < 2:
            return length

        start = end = 0
        current_index = 1
        max_sub_str_length = 1
        for i in range(current_index, length):
            is_add_sub = True
            for j in range(start, end + 1):
                if s[i] == s[j]:
                    # 发生重复字符
                    # 长度相比
                    sub_str_length = end - start + 1
                    if max_sub_str_length < sub_str_length:
                        max_sub_str_length = sub_str_length
                    # 调整 start、end
                    start = j + 1
                    end = i
                    # 标识：是否可以加入子串
                    is_add_sub = False
                    break
            if is_add_sub:
                # 注意这里是调整在前，因为这里是表示加入子串
                # start 不变，调整 end
                end = i
                # 长度相比
                sub_str_length = end - start + 1
                if max_sub_str_length < sub_str_length:
                    max_sub_str_length = sub_str_length
        return max_sub_str_length


if __name__ == "__main__":
    solution = Solution()
    assert solution.lengthOfLongestSubstring("abcabcbb") == 3
    assert solution.lengthOfLongestSubstring("bbbbb") == 1
    assert solution.lengthOfLongestSubstring("pwwkew") == 3
    assert solution.lengthOfLongestSubstring("") == 0
    assert solution.lengthOfLongestSubstring("p") == 1
    assert solution.lengthOfLongestSubstring("pp") == 1
    assert solution.lengthOfLongestSubstring("ppp") == 1
    assert solution.lengthOfLongestSubstring("pppz") == 2
    assert solution.lengthOfLongestSubstring("zppp") == 2
