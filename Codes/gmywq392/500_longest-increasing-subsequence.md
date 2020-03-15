```python3
class Solution:
    def lengthOfLIS(self, nums: list) -> int:
        if not nums: return 0
        dp = []
        for i in range(len(nums)):
            dp.append(1)
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)


if __name__ == "__main__":
    obj = Solution()
    print(obj.lengthOfLIS([1, 2, 3, 4, 5, 3, 4, 21]))
```