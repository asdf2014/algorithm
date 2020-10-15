# -*- coding: utf-8 -*-
# @Time: 2020/10/10 11:59
# @Author: GraceKoo
# @File: interview_67.py
# @Desc: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/


class Solution:
    def cuttingRope(self, n: int) -> int:
        if n < 1:
            return 0
<<<<<<< HEAD

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
=======
        dp = [0 for _ in range(n+1)]  # 用于计算已计算过的函数变量
        dp[1] = 1
        dp[2] = 1
        # 遍历dp: 即F(n)
        for i in range(3, n+1):
           # 求解loop，求每个F(n)的解
            for j in range(i):
                dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j))
        return dp[n]
>>>>>>> 1d3f2ee... dp for interview_67.py


so = Solution()
print(so.cuttingRope(10))
