# -*- coding: utf-8 -*-
# @Time: 2020/4/19 10:54
# @Author: GraceKoo
# @File: 405_convert-a-number-to-hexadecimal.py
# @Desc: https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/


class Solution:
    def toHex(self, num: int) -> str:
        num &= 0xFFFFFFFF
        mask = 0b1111
        s = "0123456789abcdef"
        result = ""
        while num > 0:
            # 从num低4位开始，每隔4位依次取结果，并对应到s的相应数字
            result += s[num & mask]
            num >>= 4  # num向右移动4位
        return result[::-1] if result else "0"


so = Solution()
print(so.toHex(26))
