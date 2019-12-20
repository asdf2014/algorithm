# -*- coding: utf-8 -*-
# @Time: 2019/12/20 1:20 下午
# @Author: GraceKoo
# @File: 8_string-to-integer-atoi.py
# @Desc: https://leetcode-cn.com/problems/string-to-integer-atoi/

import re


class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if len(s) > 0:
            pattern = r"[+-]?\d+"
            number = re.match(pattern, s)
            if number:
                number = int(number[0])
                if number < -pow(2, 31):
                    return int(-pow(2, 31))
                elif number > pow(2, 31)-1:
                    return int(pow(2, 31)-1)
                return number
        return 0


so = Solution()
print(so.myAtoi("+123"))
