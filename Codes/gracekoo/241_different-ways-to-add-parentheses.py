# -*- coding: utf-8 -*-
# @Time: 2020/4/17 12:40
# @Author: GraceKoo
# @File: 241_different-ways-to-add-parentheses.py
# @Desc: https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
from typing import List


class Solution:
    def diffWaysToCompute(self, input: str) -> List[int]:
        if input.isdigit():
            return [int(input)]
        res = []
        for index, value in enumerate(input):
            if value in ["+", "-", "*"]:
                left = self.diffWaysToCompute(input[:index])
                right = self.diffWaysToCompute(input[index + 1 :])
                # 合并结果
                for l in left:
                    for r in right:
                        if value == "+":
                            res.append(l + r)
                        elif value == "-":
                            res.append(l - r)
                        elif value == "*":
                            res.append(l * r)
        return res


so = Solution()
print(so.diffWaysToCompute("2*3-4*5"))
