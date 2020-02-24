# -*- coding: utf-8 -*-
# @Time: 2019/12/17 9:07 上午
# @Author: GraceKoo
# @File: 5_longest_palindrome.py
# @Desc:


class Solution:
    def longestPalindrome(self, s: str) -> str:
        longest_str = ""
        longestLen = 0
        matrics = [[0 for i in range(0, len(s))] for i in range(0, len(s))]

        for j in range(0, len(s)):
            for i in range(0, j + 1):
                if j - i <= 1:
                    if s[i] == s[j]:
                        matrics[i][j] = 1
                        if longestLen < j - i + 1:
                            longestLen = j - i + 1
                            longest_str = s[i : j + 1]
                else:
                    if s[i] == s[j] and matrics[i + 1][j - 1]:
                        matrics[i][j] = 1
                        if longestLen < j - i + 1:
                            longestLen = j - i + 1
                            longest_str = s[i : j + 1]
        return longest_str


s = "abccba"
so = Solution()
print(so.longestPalindrome(s))
