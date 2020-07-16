# -*- coding: utf-8 -*-
# @Time: 2020/7/16 11:38 
# @Author: GraceKoo
# @File: interview_8.py
# @Desc: https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking

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
