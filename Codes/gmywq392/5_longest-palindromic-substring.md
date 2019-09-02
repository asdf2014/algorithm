中心扩展
```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 0:
            return s

        st, ed = 0, 0

        for i in range(len(s)):
            len1 = self.expand(s, i, i)
            len2 = self.expand(s, i, i + 1)
            length = max(len1, len2)
            if length > ed - st:
                st = i - (length - 1) // 2
                ed = i + length // 2

        return s[st: ed + 1]

    def expand(self, s: str, left: int, right: int) -> int:
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return right - left - 1
```

动态规划
```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1:
            return s
        n = len(s)

        dp = [[0] * n for i in range(n)]

        right, left = 0, 0

        for i in range(n - 1, -1, -1):
            dp[i][i] = True
            for j in range(i + 1, n, 1):
                dp[i][j] = s[i] == s[j] and ((j - i) < 3 or dp[i + 1][j - 1])
                if dp[i][j] and (right - left < j - i):
                    left = i
                    right = j
        return s[left:right + 1]

```