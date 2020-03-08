# 执行用时 : 48 ms
# 内存消耗 : 13.4 MB

# 方案：n 是奇数就生成n个a； n 是偶数就生成n-1个a和一个b

class Solution:
    def generateTheString(self, n: int) -> str:
        # n 是奇数就生成n个a
        # n 是偶数就生成n-1个a和一个b
        if n%2 == 0:
            return "a" * (n-1) + "b"
        return "a"*n
