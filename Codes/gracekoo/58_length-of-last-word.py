# -*- coding: utf-8 -*-
# @Time: 2020/3/1 18:01
# @Author: GraceKoo
# @File: 58_length-of-last-word.py
# @Desc:https://leetcode-cn.com/problems/length-of-last-word/


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if not s:
            return 0
        return len(s.split()[-1])


so = Solution()
print(so.lengthOfLastWord("Hello World"))
