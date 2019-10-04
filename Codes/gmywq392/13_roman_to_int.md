```python
class Solution(object):
    def romanToInt(self, s: str) -> int:
        self.s = s
        loopup = {'M': 1000,
                  'D': 500,
                  'C': 100,
                  'L': 50,
                  'X': 10,
                  'V': 5,
                  'I': 1
                  }
        res = 0
        for i in range(len(s)):
            if i > 0 and loopup[s[i]] > loopup[s[i - 1]]:
                res += res + loopup[s[i]] - 2 * loopup[s[i - 1]]
            else:
                res += loopup[s[i]]
        return res
```