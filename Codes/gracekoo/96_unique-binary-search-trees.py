# -*- coding: utf-8 -*-
# @Time: 2020/4/13 18:49 
# @Author: GraceKoo
# @File: 96_unique-binary-search-trees.py
# @Desc: https://leetcode-cn.com/problems/unique-binary-search-trees/


class Solution:
    def numTrees(self, n: int) -> int:
        if n < 0:
            return 0
        dp = [0 for _ in range(n+1)]
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n+1):
            for j in range(i):
                dp[i] += dp[j] * dp[i - j - 1]
        return dp[-1]


so = Solution()
print(so.numTrees(3))
