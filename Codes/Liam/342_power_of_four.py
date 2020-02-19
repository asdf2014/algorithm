# 执行用时 : 88 ms
# 内存消耗 : 28.9 MB

# 方案：循环

class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        # 循环
        if num > 1:
            while num % 4 == 0:
                num //= 4
        return num == 1
