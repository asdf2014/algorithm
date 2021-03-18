#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@Author  : Star
@Email   : zsdzzydos@gmail.com
@Time    : 2019年09月09日 14:16
@Desc    : 健身计划评估
            312 ms, 23.5 MB
"""
from typing import List


class Solution:
    def dietPlanPerformance(
        self, calories: List[int], k: int, lower: int, upper: int
    ) -> int:
        total, this = 0, 0
        length = len(calories)
        for day, v in enumerate(calories):
            if day + k > length:
                break
            # 滑动窗口 移除窗口的[0]元素的值 增加窗口最后一位元素的下一位的值
            this = (
                sum(calories[day : day + k])
                if not this
                else this - calories[day - 1] + calories[day + k - 1]
            )
            if this > upper:
                total += 1
            elif this < lower:
                total -= 1
        return total


if __name__ == "__main__":
    s = Solution()
    assert s.dietPlanPerformance([1, 2, 3, 4, 5], 1, 3, 3) == 0
    assert s.dietPlanPerformance([3, 2], 2, 0, 1) == 1
    assert s.dietPlanPerformance([6, 5, 0, 0], 2, 1, 5) == 0
