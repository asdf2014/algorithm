# -*- coding: utf-8 -*-
# @Time: 2020/9/24 15:16 
# @Author: GraceKoo
# @File: interview_46.py
# @Desc: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/


class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        if n == 0:
            return -1
        i, array = 0, list(range(n))
        while len(array) > 1:
            i = (i + m - 1) % len(array)
            array.pop(i)
        return array[0]


so = Solution()
print(so.lastRemaining(5, 3))
