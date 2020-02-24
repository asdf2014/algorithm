# -*- coding: utf-8 -*-
# @Time: 2019/12/26 11:53 下午
# @Author: GraceKoo
# @File: 20_valid-parentheses.py
# @Desc:


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        dic = {"{": "}", "[": "]", "(": ")"}
        for c in s:
            if c in dic:
                stack.append(c)
            elif dic[stack.pop()] != c:
                return False
        return len(stack) == 0


so = Solution()
print(so.isValid("()[]{}"))
