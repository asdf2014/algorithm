# 执行用时 : 104 ms
# 内存消耗 : 28.7 MB

# 方案：python内置字符切分函数


class Solution:
    def countSegments(self, s: str) -> int:
        return len(s.split())
