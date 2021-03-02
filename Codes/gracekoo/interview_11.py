# -*- coding: utf-8 -*-
# @Time: 2020/7/16 15:41
# @Author: GraceKoo
# @File: interview_11.py
# @Desc: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/


class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        count = 1  # 牛客网要求只输出该数32位二进制表示中1的个数，故利用count来计数
        while n and count <= 32:
            res += n & 1
            n >>= 1
            count += 1
        return res


so = Solution()
print(so.hammingWeight(-1))
