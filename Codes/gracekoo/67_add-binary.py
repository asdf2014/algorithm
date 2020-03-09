# -*- coding: utf-8 -*-
# @Time: 2020/3/8 21:21
# @Author: GraceKoo
# @File: 67_add-binary.py
# @Desc:https://leetcode-cn.com/problems/add-binary/


class Solution:
    def addBinary(self, a: str, b: str) -> str:
        if not a and not b:
            return ""
        if not a:
            return b
        if not b:
            return a
        len_a = len(a)
        len_b = len(b)
        # 补齐两个字符串的长度
        if len_a > len_b:
            b = "0" * (len(a) - len(b)) + b
        else:
            a = "0" * (len(b) - len(a)) + a
        flag = 0
        res = ""
        for i in range(len(a) - 1, -1, -1):
            res += str((int(a[i]) + int(b[i]) + flag) % 2)
            flag = (int(a[i]) + int(b[i]) + flag) // 2
        if flag == 1:
            res += "1"
        return res[::-1]


so = Solution()
print(so.addBinary("101", "1011"))
