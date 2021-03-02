```python

class Solution:

    def compressString(self, S: str) -> str:
        if not S:
            return ""
        cu = S[0]
        cnt = 0
        ans = ""
        for i in S:
            if i == cu:
                cnt += 1
            else:
                ans += cu + str(cnt)
                cu = i
                cnt = 1
        ans += cu + str(cnt)
        if len(ans) >= len(S):
            return S
        else:
            return ans
```