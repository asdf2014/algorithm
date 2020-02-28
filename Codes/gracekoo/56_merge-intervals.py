# -*- coding: utf-8 -*-
# @Time: 2020/2/28 11:49
# @Author: GraceKoo
# @File: 56_merge-intervals.py
# @Desc:https://leetcode-cn.com/problems/merge-intervals/
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        seq = sorted(intervals)  # 先按照seq[0]排序，若seq[0]一样，则按照seq[1]排序
        i = 1
        while i < len(seq):
            if seq[i - 1][0] <= seq[i][0] <= seq[i - 1][1]:
                if seq[i][1] > seq[i - 1][1]:
                    seq[i - 1][1] = seq[i][1]
                seq.remove(seq[i])
            else:
                i += 1

        return seq


so = Solution()
print(so.merge([[1, 3], [1, 6], [1, 80], [15, 7]]))
