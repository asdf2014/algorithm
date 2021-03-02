# -*- coding: utf-8 -*-
# @Time: 2020/2/16 09:45
# @Author: GraceKoo
# @File: 44_wildcard-matching.py
# @Desc:https://leetcode-cn.com/problems/wildcard-matching/


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        s_len = len(s)
        p_len = len(p)
        dp = [[False] * (p_len + 1) for i in range(s_len + 1)]
        dp[0][0] = True
        # 初始化，如果s为空，且p的第一个字符为"*"，则置为True
        for i in range(1, p_len + 1):
            if p[i - 1] == "*":
                dp[0][i] = dp[0][i - 1]

        for i in range(1, s_len + 1):
            for j in range(1, p_len + 1):
                if s[i - 1] == p[j - 1] or p[j - 1] == "?":
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == "*":
                    dp[i][j] = dp[i - 1][j] or dp[i][j - 1]
        return dp[-1][-1]


so = Solution()
print(so.isMatch("adceb", "*a*b"))
