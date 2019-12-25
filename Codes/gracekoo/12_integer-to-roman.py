# -*- coding: utf-8 -*-
# @Time: 2019/12/25 7:29 下午
# @Author: GraceKoo
# @File: 12_integer-to-roman.py
# @Desc: https://leetcode-cn.com/problems/integer-to-roman/


class Solution:
    def intToRoman(self, num: int) -> str:
        output = ""
        roman_dict = {
            1000: "M",
            900: "CM",
            500: "D",
            400: "CD",
            100: "C",
            90: "XC",
            50: "L",
            40: "XL",
            10: "X",
            9: "IX",
            5: "V",
            4: "IV",
            1: "I",
        }
        while num > 0:
            for key, value in roman_dict.items():
                if num >= key:
                    output += value
                    num -= key
                    break
        return output


so = Solution()
print(so.intToRoman(999))
