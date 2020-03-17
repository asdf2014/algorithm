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

    def lengthOfLIS2(self, nums: list) -> int:
        if not nums: return 0
        cell = [nums[0]]
        for num in nums[1:]:
            if num > cell[-1]:
                cell.append(num)
                continue
            l, r = 0, len(cell) - 1
            while l < r:
                mid = l + (r -l) // 2
                if cell[mid] < i:
                    l = mid + 1
                else:
                    r = mid
            cell[l] = i
        return len(cell)


if __name__ == "__main__":
    obj = Solution()
    print(obj.lengthOfLIS([1, 2, 3, 4, 5, 3, 4, 21]))
```