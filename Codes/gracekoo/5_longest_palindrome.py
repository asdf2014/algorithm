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
        for end in range(n):
            for i in range(end + 1):
                if s[end] == s[i] and (end - i + 1 <= 3 or dp[i + 1][end - 1]):
                    dp[i][end] = 1
                    if len(s[i: end + 1]) > len(res):
                        res = s[i: end + 1]
        return res


so = Solution()
assert "bab" == so.longestPalindrome("babad")
assert "bb" == so.longestPalindrome("cbbd")
