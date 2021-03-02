```python3
class Solution:
    def maxAreaOfIsland(self, grid: list) -> int:
        def dfs(grid, cur_i, cur_j):
            if cur_i < 0 or cur_j < 0 or cur_i == len(grid) or cur_j == len(grid[0]) or grid[cur_i][cur_j] != 1:
                return 0
            grid[cur_i][cur_j] = 0
            ans = 1
            for i, j in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
                # cur_i, cur_j = cur_i + i, cur_j + j
                ans += dfs(grid, cur_i + i, cur_j + j)
            return ans

        res = 0
        for i, l in enumerate(grid):
            for j, n in enumerate(l):
                res = max(res, dfs(grid, i, j))
        return res


if __name__ == "__main__":
    obj = Solution()
    print(obj.maxAreaOfIsland([[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
                               [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                               [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
                               [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
                               [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
                               [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
                               [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                               [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]]))

```