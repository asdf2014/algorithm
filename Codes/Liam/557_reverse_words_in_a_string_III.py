# 执行用时 : 36 ms
# 内存消耗 : 14 MB

# 方案：python内置翻转字符串

class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(i[::-1] for i in s.split())
