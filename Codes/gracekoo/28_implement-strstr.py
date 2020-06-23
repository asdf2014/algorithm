# -*- coding: utf-8 -*-
# @Time: 2020/1/4 8:45 下午
# @Author: GraceKoo
# @File: 28_implement-strstr.py
# @Desc:https://leetcode-cn.com/problems/implement-strstr/


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # haystack.find(needle)
        haystack_len = len(haystack)
        needle_len = len(needle)
        if haystack_len < needle_len:
            return -1
        for i in range(0, haystack_len - needle_len + 1):
            if haystack[i : i + needle_len] == needle:
                return i
        return -1


so = Solution()
print(so.strStr("hello", "ll"))
