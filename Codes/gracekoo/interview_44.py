# -*- coding: utf-8 -*-
# @Time: 2020/9/24 15:15 
# @Author: GraceKoo
# @File: interview_44.py
# @Desc: https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/


class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(list(s.split())[::-1])


so = Solution()
print(so.reverseWords("abc bvc nbm"))
