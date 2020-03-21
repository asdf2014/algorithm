```python3
class Solution:
    def combinationSum2(self, candidates: list, target: int) -> list:
        candidates = sorted(candidates)
        size = len(candidates)
        if size == 0: return []
        res = []

        def dfs(begin, path, rest):
            if rest == 0:
                res.append(path[:])
                return

            for i in range(begin, size):
                if candidates[i] > rest: break
                if i > begin and candidates[i - 1] == candidates[i]: continue

                path.append(candidates[i])
                dfs(i + 1, path, rest - candidates[i])
                path.pop()

        dfs(0, [], target)
        return res

if __name__ == "__main__":
    solution = Solution()
    solution.combinationSum2([2, 2, 1, 2, 5], 5)
```