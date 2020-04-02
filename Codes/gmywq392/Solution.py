import time
from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.sort(nums, 0, len(nums) - 1)
        return nums

    def sort(self, nums, start, end):
        if start < end:
            p = self.partition(nums, start, end)
            self.sort(nums, start, p - 1)
            self.sort(nums, p + 1, end)

    def partition(self, nums, start, end):
        i = start - 1
        pivot = nums[end]
        for j in range(start, end):
            if nums[j] <= pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i + 1], nums[end] = nums[end], nums[i + 1]
        return i + 1


if __name__ == "__main__":
    solution = Solution()
    start = time.time()
    largest = solution.sortArray(
        [3, 2, 1, 5, 6, 4, 8, 9, -1, 210, 2]
    )
    end = time.time()
    print(largest, end - start)
