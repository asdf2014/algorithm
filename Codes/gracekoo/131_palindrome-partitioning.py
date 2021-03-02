# -*- coding: utf-8 -*-
# @Time: 2020/4/23 00:22
# @Author: GraceKoo
# @File: 131_palindrome-partitioning.py
# @Desc: https://leetcode-cn.com/problems/palindrome-partitioning/
from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def backtrack(s, tmp):
            if not s:
                result.append(tmp)
                return
            for i in range(1, len(s) + 1):
                if s[:i] == s[:i][::-1]:
                    backtrack(s[i:], tmp + [s[:i]])

        backtrack(s, [])
        return result


so = Solution()
print(so.partition("aab"))
