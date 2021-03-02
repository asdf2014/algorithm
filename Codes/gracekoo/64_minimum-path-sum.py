# -*- coding: utf-8 -*-
# @Time: 2020/3/8 00:12
# @Author: GraceKoo
# @File: 64_minimum-path-sum.py
# @Desc:https://leetcode-cn.com/problems/minimum-path-sum/
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        row_len = len(grid)
        col_len = len(grid[0])
        for row in range(row_len - 1, -1, -1):
            for col in range(col_len - 1, -1, -1):
                # 1.最后一行的元素，路径等于自身加右侧的权值
                if row == row_len - 1 and col != col_len - 1:
                    grid[row][col] += grid[row][col + 1]
                # 2. 除最后一行，其他行的最后一列，路径等于同列的下一行的权值加自身值
                elif row != row_len - 1 and col == col_len - 1:
                    grid[row][col] += grid[row + 1][col]
                # 3. 其他元素的路径，等于自身加上右侧权值与下侧路径的较小值
                elif row != row_len - 1 and col != col_len - 1:
                    grid[row][col] += min(grid[row + 1][col], grid[row][col + 1])
        return grid[0][0]


so = Solution()
print(so.minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]]))
