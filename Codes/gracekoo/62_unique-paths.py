# -*- coding: utf-8 -*-
# @Time: 2020/3/5 20:13
# @Author: GraceKoo
# @File: 62_unique-paths.py
# @Desc:https://leetcode-cn.com/problems/unique-paths/


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        pre = [1] * n
        cur = [1] * n
        for row in range(1, m):
            for col in range(1, n):
                cur[col] = cur[col-1] + pre[col]
            pre = cur
        return pre[-1]


so = Solution()
print(so.uniquePaths(7, 3))
