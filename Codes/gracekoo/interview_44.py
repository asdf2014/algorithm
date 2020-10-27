# -*- coding: utf-8 -*-
# @Time: 2020/9/24 15:15
# @Author: GraceKoo
# @File: interview_44.py
# @Desc: https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/


class Solution:
    def reverseWords(self, s: str) -> str:
        if not s:
            return s
        s_rotate = s.split()
        # " "的情况，直接返回s
        if len(s_rotate) <= 1:
            return s
        return " ".join(s_rotate[::-1])


so = Solution()
print(so.reverseWords("abc bvc nbm"))
