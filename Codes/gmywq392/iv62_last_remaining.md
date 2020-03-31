```python3
class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        ans = 0
        for i in range(2, n + 1):
            ans = (ans + m) % i
        return ans
if __name__ == "__main__":
    solution = Solution()
    print(solution.lastRemaining(16, 5))
```