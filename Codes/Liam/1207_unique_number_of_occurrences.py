# 执行用时 : 36 ms
# 内存消耗 : 13.2 MB

# 方案：哈希字典


class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        from collections import Counter

        cor_dict = Counter(arr)
        values = cor_dict.values()
        return True if len(values) == len(list(set(values))) else False
