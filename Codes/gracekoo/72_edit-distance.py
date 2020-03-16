# -*- coding: utf-8 -*-
# @Time: 2020/3/16 12:03
# @Author: GraceKoo
# @File: 72_edit-distance.py
# @Desc:https://leetcode-cn.com/problems/edit-distance/


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n1 = len(word1)
        n2 = len(word2)
        dp = [[0] * (n2 + 1) for _ in range(n1 + 1)]
        # 第一行，进行初始化
        for i in range(1, n2 + 1):
            dp[0][i] = dp[0][i - 1] + 1
        # 第一列，进行初始化
        for j in range(1, n1 + 1):
            dp[j][0] = dp[j - 1][0] + 1
        for i in range(1, n1 + 1):
            for j in range(1, n2 + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
        return dp[-1][-1]


so = Solution()
print(so.minDistance(word1="horse", word2="ros"))
