# -*- coding: utf-8 -*-
# @Time: 2020/9/23 18:33 
# @Author: GraceKoo
# @File: interview_41.py
# @Desc: https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
from typing import List


class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        i = 1  # 左边界
        j = 1  # 右边界
        sum_current = 0  # 当前滑动窗口中的总和
        result = []

        # 左边界不得超过target的中值
        while i <= target // 2:
            if sum_current < target:
                sum_current += j
                j += 1
            elif sum_current > target:
                sum_current -= i
                i += 1
            else:
                result.append(list(range(i, j)))
                sum_current -= i
                i += 1
        return result


so = Solution()
print(so.findContinuousSequence(10))
