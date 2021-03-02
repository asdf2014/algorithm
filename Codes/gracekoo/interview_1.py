# -*- coding: utf-8 -*-
# @Time: 2020/5/7 12:31
# @Author: GraceKoo
# @File: interview_1.py
# @Desc: https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
from typing import List


class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or target is None:
            return False

        rows = len(matrix)
        cols = len(matrix[0])
        if rows == 0 or cols == 0:
            return False

        # 从右上角开始搜索
        x = 0
        y = cols - 1
        while x < rows and y >= 0:
            if matrix[x][y] == target:
                return True
            # 从matrix[x][y]的左下角部分进行搜索
            if matrix[x][y] > target:
                y -= 1
            else:
                x += 1
        return False


so = Solution()
print(
    so.findNumberIn2DArray(
        [
            [1, 4, 7, 11, 15],
            [2, 5, 8, 12, 19],
            [3, 6, 9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30],
        ],
        21,
    )
)
