# -*- coding: utf-8 -*-
# @Time: 2020/3/11 12:09
# @Author: GraceKoo
# @File: 70_climbing-stairs.py
# @Desc:https://leetcode-cn.com/problems/climbing-stairs/


class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [i for i in range(n)]
        dp[0] = 1
        dp[1] = 2
        for i in range(2, n):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[-1]


so = Solution()
print(so.climbStairs(3))
