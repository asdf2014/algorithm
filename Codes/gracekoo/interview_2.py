# -*- coding: utf-8 -*-
# @Time: 2020/5/8 22:38
# @Author: GraceKoo
# @File: interview_2.py
# @Desc: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/


class Solution:
    def replaceSpace(self, s: str) -> str:
        s_list = list()
        for s_value in s:
            if s_value == " ":
                s_list.append("%20")
            else:
                s_list.append(s_value)

        return "".join(s_list)


so = Solution()
print(so.replaceSpace("We are happy."))
