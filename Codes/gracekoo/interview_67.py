# -*- coding: utf-8 -*-
# @Time: 2020/10/10 11:59
# @Author: GraceKoo
# @File: interview_67.py
# @Desc: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/


class Solution:
    def cuttingRope(self, n: int) -> int:
        if n < 1:
            return 0
        dp = [0 for _ in range(n + 1)]  # 用于计算已计算过的函数变量
        dp[1] = 1
        dp[2] = 1
        # 遍历dp: 即F(n)
        for i in range(3, n + 1):
            # 求解loop，求每个F(n)的解
            # j代表在i长的绳子上要怎么剪，j==0or==i都代表不需要剪
            for j in range(i):
                dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j))
        return dp[n]


so = Solution()
print(so.cuttingRope(10))
