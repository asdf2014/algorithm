# -*- coding: utf-8 -*-
# @Time: 2020/4/5 22:40
# @Author: GraceKoo
# @File: 91_decode-ways.py
# @Desc: https://leetcode-cn.com/problems/decode-ways/


class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == "0":
            return 0
        dp = [1, 0]
        dp[1] = 1 if s[0] != 0 else 0  # dp[i] -> s[i-1]
        n = len(s)
        for i in range(1, n):
            dp.append(0)
            if s[i] != "0":
                dp[i+1] += dp[i]
            if "10" <= s[i-1:i+1] <= "26":
                dp[i+1] += dp[i-2]
        # print(dp)
        return dp[-1]


so = Solution()
print(so.numDecodings("226"))
