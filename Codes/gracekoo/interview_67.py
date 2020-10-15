# -*- coding: utf-8 -*-
# @Time: 2020/10/10 11:59
# @Author: GraceKoo
# @File: interview_67.py
# @Desc: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/


class Solution:
    def cuttingRope(self, n: int) -> int:
        if n < 1:
            return 0

        def memorize(n):
            if n == 2:
                return 1
            if fn[n] != 0:
                return fn[n]

            result = -1  # result用于保存最终的结果
            # 1 * F(n-1)、2 * F(n-2).....、i * F(n - i)
            for i in range(1, n):
                # 剪或不剪
                result = max(result, max(i * (n - i), i * memorize(n - i)))
            fn[n] = result
            return result

        fn = [0 for _ in range(n + 1)]  # 用于计算已计算过的函数变量
        return memorize(n)


so = Solution()
print(so.cuttingRope(10))
