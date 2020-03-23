import collections
import time


class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        ans = cur = 0
        vis = {0: -1}
        pre = collections.defaultdict(int)
        for i, c in enumerate('aeiou'):
            pre[c] = 1 << (i + 1) >> 1
        for i, c in enumerate(s):
            cur ^= pre[c]
            vis.setdefault(cur, i)
            ans = max(ans, i - vis[cur])
        return ans


if __name__ == "__main__":
    solution = Solution()
    start = time.time()
    largest = solution.findTheLongestSubstring(
        'aeeeioooaaazxx')
    end = time.time()
    print(largest, end - start)
