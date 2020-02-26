# -*- coding: utf-8 -*-
# @Time: 2020/2/26 14:27
# @Author: GraceKoo
# @File: 54_spiral-matrix.py
# @Desc:https://leetcode-cn.com/problems/spiral-matrix/
from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        def spiral_matrix(r1, c1, r2, c2):
            for c in range(c1, c2 + 1):
                yield r1, c
            for r in range(r1 + 1, r2 + 1):
                yield r, c2
            if r1 < r2 and c1 < c2:
                for c in range(c2 - 1, c1, -1):
                    yield r2, c
                for r in range(r2, r1, -1):
                    yield r, c1

        if not matrix:
            return []
        output = []
        r1, r2 = 0, len(matrix) - 1
        c1, c2 = 0, len(matrix[0]) - 1
        while r1 <= r2 and c1 <= c2:
            for r, c in spiral_matrix(r1, c1, r2, c2):
                output.append(matrix[r][c])
            r1 += 1
            r2 -= 1
            c1 += 1
            c2 -= 1
        return output


so = Solution()
print(so.spiralOrder([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]))
