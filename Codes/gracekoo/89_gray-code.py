# -*- coding: utf-8 -*-
# @Time: 2020/4/2 23:45
# @Author: GraceKoo
# @File: 89_gray-code.py
# @Desc:https://leetcode-cn.com/problems/gray-code/
from typing import List


class Solution:
    def grayCode(self, n: int) -> List[int]:
        res, head = [0], 1
        for i in range(n):
            for j in range(len(res) - 1, -1, -1):
                res.append(head + res[j])
            head <<= 1
        return res


so = Solution()
print(so.grayCode(2))
