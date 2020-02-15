# 执行用时 : 40 ms
# 内存消耗 : 12.9 MB

# 方案：斐波那契数列


class Solution:
    def climbStairs(self, n: int) -> int:
        # if n == 1:
        #     return 1
        # elif n == 2:
        #     return 2
        # else:
        #     s1 = self.climbStairs(n-1)
        #     s2 = self.climbStairs(n-2)
        #     return s1+s2
        # time exceeds

        # fib = [1, 1, 2]
        # if n == 1:
        #     return fib[1]
        # elif n == 2:
        #     return fib[2]
        # else:
        #     for i in range(3, n+1):
        #         fib.append(fib[i-1] + fib[i-2])
        # return fib[n]
        import math

        return int(
            (
                math.pow(((1 + math.sqrt(5)) / 2), n + 1)
                - math.pow((1 - math.sqrt(5)) / 2, n + 1)
            )
            / math.sqrt(5)
        )
