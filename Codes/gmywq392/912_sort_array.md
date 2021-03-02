```python3
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.sort(nums, 0, len(nums) - 1)
        return nums

    def sort(self, nums, start, end):
        if start < end:
            p = self.partition(nums, start, end)
            self.sort(nums, start, p - 1)
            self.sort(nums, p + 1, end)

    def partition(self, nums, l, r):
        i = l - 1
        pivot = nums[r]
        for j in range(l, r):
            if nums[j] <= pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i + 1], nums[r] = nums[r], nums[i + 1]
        return i + 1
```