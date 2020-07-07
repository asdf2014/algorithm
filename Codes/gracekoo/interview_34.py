# -*- coding: utf-8 -*-
# @Time: 2020/7/7 10:56
# @Author: GraceKoo
# @File: interview_34.py
# @Desc: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/


class Solution:
    def firstUniqChar(self, s: str) -> str:
        result_dict = {}
        for item in s:
            result_dict[item] = item not in result_dict
        for k, v in result_dict.items():
            if v:
                return k
        return " "


so = Solution()
print(so.firstUniqChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"))
