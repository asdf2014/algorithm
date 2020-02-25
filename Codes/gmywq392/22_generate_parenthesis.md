```python
class Solution:
    def generateParenthesis(self, n: int) -> list:
        ans = []

        def backtrack(S='', left=0, right=0):
            if len(S) == 2 * n:
                ans.append(S)
                return
            if left < n:
                backtrack(S + '(', left + 1, right)
            if right < left:
                backtrack(S + ')', left, right + 1)

        backtrack('', 0, 0)
        return ans


if __name__ == '__main__':
    ar = [3, 2, 4, 1]
    solution = Solution()
    print(solution.generateParenthesis(4))
```