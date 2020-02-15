# 执行用时 : 32 ms
# 内存消耗 : 13 MB

# 方案：最左边的6，把它替换成9


class Solution:
    def maximum69Number(self, num: int) -> int:
        return int(str(num).replace("6", "9", 1))
