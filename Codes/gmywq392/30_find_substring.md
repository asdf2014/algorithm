```python
# Definition for singly-linked list.

class Solution:
    
    def findSubstring(self, s: str, words: list) -> list:
        from collections import Counter
        if not s or not words: return []
        all_len = sum(map(len, words))
        one_len = len(words[0])
        n = len(s)
        words = Counter(words)
        res = []
        for i in range(0, n - all_len + 1):
            tmp = s[i:i + all_len]
            c_tmp = []
            for j in range(0, all_len, one_len):
                c_tmp.append(tmp[j:j + one_len])
            if Counter(c_tmp) == words:
                res.append(i)
        return res
```