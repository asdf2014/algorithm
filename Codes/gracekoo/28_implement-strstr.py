# -*- coding: utf-8 -*-
# @Time: 2020/1/4 8:45 下午
# @Author: GraceKoo
# @File: 28_implement-strstr.py
# @Desc:https://leetcode-cn.com/problems/implement-strstr/


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # haystack.find(needle)
        if len(haystack) < len(needle):
            return -1
        j = 0
        for i in range(0, len(haystack) - len(needle) + 1):
            index = i
            for j in range(0, len(needle)):
                if haystack[i] != needle[j]:
                    break
                i += 1
            if j == len(needle) - 1:
                return index
        return -1


so = Solution()
print(so.strStr("hello", "ll"))
