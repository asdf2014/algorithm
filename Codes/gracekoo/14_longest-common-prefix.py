# -*- coding: utf-8 -*-
# @Time: 2019/12/25 9:12 下午
# @Author: GraceKoo
# @File: 14_longest-common-prefix.py
# @Desc: https://leetcode-cn.com/problems/longest-common-prefix/
class Solution:
    def longestCommonPrefix(self, li) -> str:
        if not li:
            return ""
        # 按照ASCII码进行排序
        min_str = min(li)
        max_str = max(li)
        for index, value in enumerate(min_str):
            if value != max_str[index]:
                return max_str[:index]
        return min_str


so = Solution()
print(so.longestCommonPrefix(["flower", "flow", "flight"]))
