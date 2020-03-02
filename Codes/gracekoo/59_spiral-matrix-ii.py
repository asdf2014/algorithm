# -*- coding: utf-8 -*-
# @Time: 2020/3/1 18:14
# @Author: GraceKoo
# @File: 59_spiral-matrix-ii.py
# @Desc:https://leetcode-cn.com/problems/spiral-matrix-ii/
from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        if n < 1:
            return []

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

        output_matrix = [[0 for i in range(n)] for i in range(n)]
        r1, r2 = 0, len(output_matrix) - 1
        c1, c2 = 0, len(output_matrix[0]) - 1
        number = 1
        while r1 <= r2 and c1 <= c2:
            for r, c in spiral_matrix(r1, c1, r2, c2):
                output_matrix[r][c] = number
                number += 1
            r1 += 1
            r2 -= 1
            c1 += 1
            c2 -= 1
        return output_matrix


so = Solution()
print(so.generateMatrix(3))
