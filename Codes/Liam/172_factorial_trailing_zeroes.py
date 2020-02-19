# 执行用时 : 96 ms
# 内存消耗 : 29 MB

# 方案：算一下乘法因子里面5的个数

class Solution:
    def trailingZeroes(self, n: int) -> int:
        # 算一下乘法因子里面5的个数
        count = 0
        while n:
            count += n//5
            n //= 5
        return count
