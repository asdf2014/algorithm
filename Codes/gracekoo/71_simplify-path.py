# -*- coding: utf-8 -*-
# @Time: 2020/3/12 12:01
# @Author: GraceKoo
# @File: 71_simplify-path.py
# @Desc:https://leetcode-cn.com/problems/simplify-path/


class Solution:
    def simplifyPath(self, path: str) -> str:
        if not path:
            return ""
        result_list = []
        path = path.split("/")
        for value in path:
            if value == "..":
                if result_list:
                    result_list.pop()
            elif value and value != ".":
                result_list.append(value)
        return "/" + "/".join(result_list)


so = Solution()
print(so.simplifyPath("/a/./b/../../c/"))
