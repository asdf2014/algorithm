# -*- coding: utf-8 -*-
# @Time: 2020/3/17 19:59 
# @Author: GraceKoo
# @File: 74_search-a-2d-matrix.py
# @Desc:https://leetcode-cn.com/problems/search-a-2d-matrix/
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return False
        rows = len(matrix)
        cols = len(matrix[0])
        left = 0
        right = rows * cols - 1
        while left <= right:
            middle = (left + right) // 2
            row = middle // cols
            col = middle % cols
            if matrix[row][col] == target:
                return True
            if matrix[row][col] > target:
                right = middle - 1
            else:
                left = middle + 1
        return False


so = Solution()
print(so.searchMatrix([
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
], 3))
