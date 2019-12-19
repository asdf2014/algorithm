# -*- coding: utf-8 -*-
# @Time: 2019/12/19 1:05 下午
# @Author: GraceKoo
# @File: 7_reverse-integer.py
# @Desc: https://leetcode-cn.com/problems/reverse-integer/


class Solution:
    def reverse(self, x: int) -> int:
        if not x:
            return x

        len_x = len(str(x))
        reverse_x = ""
        for i in range(0, len_x):
            middle_x = (x % pow(10, i + 1)) // pow(10, i)
            reverse_x = reverse_x + str(middle_x)
        return reverse_x


s = 123456789
so = Solution()
print(so.reverse(s))
