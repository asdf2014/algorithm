# -*- coding: utf-8 -*-
# @Time: 2019/12/17 9:07 上午
# @Author: GraceKoo
# @File: 5_longest_palindrome.py
# @Desc: https://leetcode-cn.com/problems/longest-palindromic-substring/


class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        n = len(s)
        # dp[j][i] 表示从j到i是否是回文串
        # 如果 s[j] == s[i] && (dp[j+1][i-1] 也是回文串)，那么字符串从 j 到 i 也是回文串，即 dp[j][i] 为真
        dp = [[0] * n for _ in range(n)]
        res = ""
        for i in range(n):
            for j in range(i + 1):
                if s[i] == s[j] and (i - j + 1 <= 3 or dp[j + 1][i - 1]):
                    dp[j][i] = 1
                    if len(s[j : i + 1]) > len(res):
                        res = s[j : i + 1]
        return res


so = Solution()
assert "bab" == so.longestPalindrome("babad")
assert "bb" == so.longestPalindrome("cbbd")
