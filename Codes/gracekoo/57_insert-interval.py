# -*- coding: utf-8 -*-
# @Time: 2020/2/29 11:45
# @Author: GraceKoo
# @File: 57_insert-interval.py
# @Desc:https://leetcode-cn.com/problems/insert-interval/
from typing import List


class Solution:
    def insert(self, intervals: 'List[Interval]', newInterval: 'Interval') -> 'List[Interval]':
        start, end = newInterval
        current, n = 0, len(intervals)
        output = []

        # 将newInterval之前的序列直接添加到output中
        while current < n and intervals[current][0] < start:
            output.append(intervals[current])
            current += 1

        # 添加newInterval到output中
        if not output and output[-1][1] < start:
            output.append(newInterval)
        else:
            output[-1][1] = max(end, output[-1][1])

        # 添加剩余的interval
        while current < n:
            if output[-1][1] < intervals[current][0]:
                output.append(intervals[current])
            else:
                output[-1][1] = max(intervals[current][1], output[-1][1])
            current += 1
        return output


so = Solution()
print(so.insert([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8]))
