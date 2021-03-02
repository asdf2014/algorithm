# -*- coding: utf-8 -*-
# @Time: 2020/9/23 18:33
# @Author: GraceKoo
# @File: interview_43.py
# @Desc: https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/


class Solution:
    def reverseLeftWords(self, s: str, n: int) -> str:
        len_s = len(s)
        if n >= len_s or n <= 0:
            return s
        return s[n:] + s[:n]


so = Solution()
print(so.reverseLeftWords("abcdefg", 2))
