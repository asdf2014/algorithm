# -*- coding: utf-8 -*-
# @Time: 2020/7/16 11:36 
# @Author: GraceKoo
# @File: interview_7.py
# @Desc: https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qr
# u=%2Fta%2Fcoding-interviews%2Fquestion-ranking


class Solution:
    def fib(self, N: int) -> int:
        if N <= 1:
            return N
        f_dict = {0: 0, 1: 1}
        for i in range(2, N):
            f_dict[i] = f_dict[i - 1] + f_dict[i - 2]
        return f_dict[N - 1]


so = Solution()
print(so.fib(4))