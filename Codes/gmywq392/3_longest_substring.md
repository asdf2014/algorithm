
```python
class Solution:
    def lengthOfLongestSubstring(s: str) -> int:
        res = 0
        used = {}
        st = 0
        for curr, char in enumerate(s):
            if char in used:
                st = max(used[char], st)
            res = max(res, curr - st + 1)
            used[char] = curr + 1
        return res

```