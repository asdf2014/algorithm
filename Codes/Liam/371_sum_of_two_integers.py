# 执行用时 : 44 ms
# 内存消耗 : 13.4 MB

# 方案：计算机组成原理

class Solution:
    def getSum(self, a: int, b: int) -> int:
        while b:
            a, b = (a^b)&0xFFFFFFFF,(a&b)<<1 
        return a if a >> 31 == 0 else a - 4294967296
