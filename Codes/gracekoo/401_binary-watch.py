# -*- coding: utf-8 -*-
# @Time: 2020/4/20 12:38
# @Author: GraceKoo
# @File: 401_binary-watch.py
# @Desc:https://leetcode-cn.com/problems/binary-watch/
from typing import List


class Solution:
    def readBinaryWatch(self, num: int) -> List[str]:
        def count_binary_1(i):
            return bin(i).count("1")

        # 1~59分钟转换成二进制里面分别有多少1
        dict_binary = {i: count_binary_1(i) for i in range(60)}
        res = []
        for h in range(12):
            for m in range(60):
                # hour 与 minutes 亮灯的两者之和与num相等
                if dict_binary[h] + dict_binary[m] == num:
                    hour = str(h)
                    m = str(m) if m > 9 else "0" + str(m)
                    res.append(hour + ":" + m)
        return res


so = Solution()
print(so.readBinaryWatch(1))
