```python
# Definition for singly-linked list.

class Solution:
    def removeDuplicates(self, nums: list) -> int:
        if not nums: return 0

        j = 0
        for i in range(len(nums)):
            if nums[j] != nums[i]:
                j += 1
                nums[j] = nums[i]

        return j + 1

if __name__ == '__main__':
    ar = [1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 6]
    solution = Solution()
    print(solution.removeDuplicates(ar))

```