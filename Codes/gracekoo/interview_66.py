# -*- coding: utf-8 -*-
# @Time: 2020/10/10 11:58
# @Author: GraceKoo
# @File: interview_66.py
# @Desc: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
from collections import deque


class Solution:
    def movingCount_BFS(self, m: int, n: int, k: int) -> int:
        # 用于计算数位和
        def sum_step(row, col):
            result = 0
            while row > 0:
                result += row % 10
                row = row // 10
            while col > 0:
                result += col % 10
                col = col // 10
            return result

        # 广度优先搜索
        de = deque()  # 用于广度优先搜索格子的坐标
        de.append((0, 0))
        marked = set()  # 用于记录已经走过的坐标
        while de:
            x, y = de.popleft()
            # 如果当前坐标还没有走过，并且数位和小于等于k
            if (x, y) not in marked and sum_step(x, y) <= k:
                marked.add((x, y))
                # 只考虑向下和向右即可
                for dx, dy in [(1, 0), (0, 1)]:
                    if x + dx < m and y + dy < n:
                        de.append((x+dx, y+dy))
        return len(marked)

    def movingCount_DFS(self, m: int, n: int, k: int) -> int:
        # 用于计算数位和
        def sum_step(row, col):
            result = 0
            while row > 0:
                result += row % 10
                row = row // 10
            while col > 0:
                result += col % 10
                col = col // 10
            return result

        def dfs(x, y):
            # 递归退出的条件
            # 坐标超出范围、数位和大于k、当前坐标已经走过
            if x >= m or y >= n or sum_step(x, y) > k or (x, y) in marked:
                return

            marked.add((x, y))
            dfs(x + 1, y)  # 向下走
            dfs(x, y + 1)  # 向右走

        marked = set()  # 记录已经走过的坐标
        dfs(0, 0)
        return len(marked)
