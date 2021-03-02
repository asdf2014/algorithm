# -*- coding: utf-8 -*-
# @Time: 2019/12/18 11:52 下午
# @Author: GraceKoo
# @File: 6_convert.py
# @Desc: https://leetcode-cn.com/problems/zigzag-conversion/


class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if not s:
            return ""
        elif len(s) == 1:
            return s

        outstr = [""] * numRows
        i = 0
        while i < len(s):
            for j in range(0, numRows):
                if i < len(s):
                    outstr[j] += s[i]
                    i += 1
            for j in range(numRows - 2, 0, -1):
                if i < len(s):
                    outstr[j] += s[i]
                    i += 1
        outstr = "".join(outstr)
        return outstr


s = "ABCDE"
so = Solution()
print(so.convert(s, 3))
