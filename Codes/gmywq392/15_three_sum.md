```python
class Solution(object):
    def threeSum(self, nums):
        res = []
        nums.sort()
        for i in range(len(nums)):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i-1]:
                continue
            j = i + 1
            k = len(nums) - 1
            while j < k :
                if nums[j] + nums[k] == -nums[i]:
                    res.append([nums[i],nums[j], nums[k]])
                    j += 1
                    k -= 1
                    while j < k and nums[j]==nums[j-1]: j += 1
                    while j < k and nums[k]==nums[k+1]: k -= 1
                elif nums[j] + nums[k] >= -nums[i]:
                    k -= 1
                else:
                    j += 1
        return  res
```