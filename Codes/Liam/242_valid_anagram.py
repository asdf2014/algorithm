# 执行用时 : 148 ms
# 内存消耗 : 29.2 MB

# 方案：python语句


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # pythonic 解法
        # 执行用时 : 148 ms, 在所有 Python3 提交中击败了5.10%的用户
        # 内存消耗 : 29.2 MB, 在所有 Python3 提交中击败了5.35%的用户
        # from collections import Counter
        # return Counter(s) == Counter(t)

        return sorted(s) == sorted(t)
