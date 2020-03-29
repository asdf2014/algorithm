# -*- coding: utf-8 -*-
# @Time: 2020/3/29 16:24
# @Author: GraceKoo
# @File: 84_largest-rectangle-in-histogram.py
# @Desc:https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
from typing import List


class Solution:
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
print(so.largestRectangleArea([2, 1, 5, 6, 2, 3]))
