# -*- coding: utf-8 -*-
# @Time: 2020/3/22 22:32
# @Author: GraceKoo
# @File: 77_combinations.py
# @Desc:https://leetcode-cn.com/problems/combinations/
from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if n <= 0 or k <= 0 or n < k:
            return []
        result = []
        self.__dfs(1, k, n, [], result)
        return result

    def __dfs(self, index, k, n, pre, result):
        if len(pre) == k:
            result.append(pre[:])
            return
        for i in range(index, n + 1):
            pre.append(i)
            self.__dfs(i + 1, k, n, pre, result)
            pre.pop()


so = Solution()
print(so.combine(4, 2))
