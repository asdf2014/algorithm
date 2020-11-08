# -*- coding: utf-8 -*-
# @Time: 2020/9/25 14:37
# @Author: GraceKoo
# @File: interview_49.py
# @Desc: https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/

class Solution:
    def strToInt(self, str: str) -> int:
        if not str:
            return 0
        # string = str.split()[0]  # 不使用split，strip等方法可以将空间复杂度降到O(1)
        result, i, sign, len_str = 0, 0, 1, len(str)  # 结果，开始的索引，正负号，str的长度
        int_max, int_min, boundary = 2 ** 31 - 1, -(2 ** 31), 2 ** 31 // 10

        # 去除空格
        while str[i] == " ":
            i += 1
            if i == len_str:  # 空字符串
                return 0

        # 判断符号
        if str[i] == "-":
            sign = -1
        if str[i] in ("+", "-"):
            i += 1

        # 整数拼接
        for c in str[i:]:
            i += 1
            if not "0" <= c <= "9":
                break
            if result > boundary or (result == boundary and c > "7"):
                return int_max if sign == 1 else int_min
            result = result * 10 + ord(c) - ord("0")  # 结果通过字符与"0"的ASCII码求得

        # 求小数部分
        x = 1
        if str[i-1] == ".":
            for c in str[i:]:
                if not "0" <= c <= "9":
                    break
                if result > boundary or (result == boundary and c > "7"):
                    return int_max if sign == 1 else int_min
                result = result + (ord(c) - ord("0")) * 0.1 ** x
                x += 1

        return sign * result


so = Solution()
print(so.strToInt("+12.3"))

