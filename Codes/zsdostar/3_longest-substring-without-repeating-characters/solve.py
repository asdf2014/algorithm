#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Author  : Star
@Email   : zsdzzydos@gmail.com
@Time    : 2019年09月09日 13:48
@Desc    : 无重复字符的最长子串
"""


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        68 ms, 7.5 MB
        滑动窗口解法
        :type s: str
        :rtype: int
        """
        sub, smax = "", 0
        for i in s:
            if not sub:
                sub, smax = i, 1
                continue

            if i not in sub:
                sub += i
            else:
                sub = sub[
                    sub.index(i) + 1 :
                ]  # sub == 'abc'; i == 'a'; so, sub = 'abc'[1:]; sub += 'a'
                sub += i
            smax = len(sub) if len(sub) > smax else smax

        return smax


if __name__ == "__main__":
    s = Solution()
    assert s.lengthOfLongestSubstring("abcabcbb") == 3
    assert s.lengthOfLongestSubstring("bbbbb") == 1
    assert s.lengthOfLongestSubstring("pwwkew") == 3
