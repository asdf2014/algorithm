# -*- coding: utf-8 -*-
# @Time: 2020/3/30 22:22
# @Author: GraceKoo
# @File: 85_maximal-rectangle.py
# @Desc:https://leetcode-cn.com/problems/maximal-rectangle/
from typing import List


class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        max_area = 0
        dp = [0] * len(matrix[0])
        for row in range(0, len(matrix)):
            for col in range(0, len(matrix[0])):
                dp[col] = dp[col] + 1 if matrix[row][col] == "1" else 0
            max_area = max(max_area, self.largestRectangleArea(dp))
        return max_area

    # from 84_largest-rectangle-in-histogram
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        res = 0
        heights = [0] + heights + [0]
        for i in range(len(heights)):
            while stack and heights[i] < heights[stack[-1]]:
                tmp = stack.pop()
                res = max(res, (i - stack[-1] - 1) * heights[tmp])
            stack.append(i)
        return res


so = Solution()
print(
    so.maximalRectangle(
        [
            ["1", "0", "1", "0", "0"],
            ["1", "0", "1", "1", "1"],
            ["1", "1", "1", "1", "1"],
            ["1", "0", "0", "1", "0"],
        ]
    )
)
