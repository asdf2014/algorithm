```python
# Definition for singly-linked list.

class Solution:
    def removeElement(self, nums: list, val: int) -> int:
        if not nums: return 0
        count = 0
        for i in  range(len(nums)):
            if nums[i] != val:
                nums[count] = nums[i]
                count += 1
        return j + 1

if __name__ == '__main__':
    ar = [1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 6]
    solution = Solution()
    print(solution.removeDuplicates(ar))

```