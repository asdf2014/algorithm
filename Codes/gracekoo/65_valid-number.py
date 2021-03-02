# -*- coding: utf-8 -*-
# @Time: 2020/3/8 00:41
# @Author: GraceKoo
# @File: 65_valid-number.py
# @Desc:https://leetcode-cn.com/problems/valid-number/


class Solution:
    def isNumber(self, s: str) -> bool:
        # return bool(re.match(r' *[+-]?([0-9]+(\.[0-9]*)?|\.[0-9]+)(e[+-]?[0-9]+)? *$', s))
        s = s.strip()
        # 去除s两边的空白符
        if not s:
            return False
        # 去除"+"、"-"
        if s[0] in ["+", "-"]:
            s = s[1:]
        # 判断是否含有e
        if "e" in s:
            s_list = s.split("e")
            # 说明有两个e
            if len(s_list) > 2:
                return False
            # 去掉e前面的"."
            s_list[0] = s_list[0].replace(".", "", 1)
            # 去掉e后面的"+、"-"
            if len(s_list[1]) > 0 and s_list[1][0] in ["+", "-"]:
                s_list[1] = s_list[1].replace(s_list[1][0], "", 1)
            # 判断是否为数字
            if s_list[0].isnumeric() and s_list[1].isnumeric():
                return True
        else:
            s = s.replace(".", "", 1)
            if s.isnumeric():
                return True
        return False


so = Solution()
print(so.isNumber("53.5e93"))
