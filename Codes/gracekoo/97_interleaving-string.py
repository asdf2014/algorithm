# -*- coding: utf-8 -*-
# @Time: 2020/4/12 21:47 
# @Author: GraceKoo
# @File: 97_interleaving-string.py
# @Desc: https://leetcode-cn.com/problems/interleaving-string/


class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        len_s1 = len(s1)
        len_s2 = len(s2)
        len_s3 = len(s3)
        if len_s1 + len_s2 != len_s3:
            return False
        dp = [[False for _ in range(len_s2+1)] for _ in range(len_s1+1)]
        dp[0][0] = True
        # 初始化第一行
        for j in range(1, len_s2+1):
            dp[0][j] = True if s3[j-1] == s2[j-1] else False
        # 初始化第一列
        for i in range(1, len_s1+1):
            dp[i][0] = True if s3[i-1] == s1[i-1] else False
        for i in range(1, len_s1+1):
            for j in range(1, len_s2+1):
                if dp[i-1][j] and s1[i-1] == s3[i+j-1]:
                    dp[i][j] = True
                if dp[i][j-1] and s2[j-1] == s3[i+j-1]:
                    dp[i][j] = True
        return dp[-1][-1]


so = Solution()
print(so.isInterleave(s1="aabcc", s2="dbbca", s3="aadbbcbcac"))
