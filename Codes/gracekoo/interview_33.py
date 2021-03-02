# -*- coding: utf-8 -*-
# @Time: 2020/7/3 10:21
# @Author: GraceKoo
# @File: interview_33.py
# @Desc: https://leetcode-cn.com/problems/chou-shu-lcof/


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n <= 0:
            return 0
        dp, a, b, c = [1] * n, 0, 0, 0
        for i in range(1, n):
            min_ugly = min(dp[a] * 2, dp[b] * 3, dp[c] * 5)
            dp[i] = min_ugly
            if min_ugly == dp[a] * 2:
                a += 1
            if min_ugly == dp[b] * 3:
                b += 1
            if min_ugly == dp[c] * 5:
                c += 1
        return dp[-1]


so = Solution()
print(so.nthUglyNumber(10))
