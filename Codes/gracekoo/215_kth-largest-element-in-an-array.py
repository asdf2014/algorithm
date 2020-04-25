# -*- coding: utf-8 -*-
# @Time: 2020/4/25 12:43
# @Author: GraceKoo
# @File: 215_kth-largest-element-in-an-array.py
# @Desc: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
from typing import List
import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(2, nums)[-1]


so = Solution()
print(so.findKthLargest([3, 2, 1, 5, 6, 4], 2))
