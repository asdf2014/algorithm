```python
import sys

class Solution(object):
    def threeSumClosest(self, nums: [], target: int) -> int:
        nums.sort()
        diff = sys.maxsize
        res = 1
        for i in range(len(nums)):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                temp_diff = abs(target - s)

                if temp_diff < diff:
                    diff = temp_diff
                    res = s

                if s < target:
                    j += 1
                elif s > target:
                    k -= 1
                else:
                    return s
        return res
```