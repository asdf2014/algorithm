# -*- coding: utf-8 -*-
# @Time: 2020/3/17 12:08
# @Author: GraceKoo
# @File: 73_set-matrix-zeroes.py
# @Desc:https://leetcode-cn.com/problems/set-matrix-zeroes/
from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> List:
        """
        Do not return anything, modify matrix in-place instead.
        """
        flag_col = False
        rows = len(matrix)
        cols = len(matrix[0])
        for row in range(rows):
            if matrix[row][0] == 0:
                flag_col = True
            for col in range(1, cols):
                if matrix[row][col] == 0:
                    matrix[row][0] = matrix[0][col] = 0
        for row in range(rows - 1, -1, -1):
            for col in range(cols - 1, 0, -1):
                if matrix[row][0] == 0 or matrix[0][col] == 0:
                    matrix[row][col] = 0
            if flag_col:
                matrix[row][0] = 0
        return matrix


so = Solution()
print(so.setZeroes([[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]))
