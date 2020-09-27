# -*- coding: utf-8 -*-
# @Time: 2020/9/25 14:37
# @Author: GraceKoo
# @File: interview_51.py
# @Desc: https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
from typing import List


class Solution:
    def constructArr(self, a: List[int]) -> List[int]:
        b, tmp = [1] * len(a), 1
        # 先计算下三角
        for i in range(1, len(a)):
            b[i] = b[i - 1] * a[i - 1]
        # 再计算上三角
        for i in range(len(a) - 2, -1, -1):
            tmp *= a[i + 1]
            b[i] *= tmp
        return b


so = Solution()
print(so.constructArr([1, 2, 3, 4, 5]))
