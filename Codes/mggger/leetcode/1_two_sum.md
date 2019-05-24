# code

``` python
class Solution(object):
    def twoSum(self, nums, target):
        d = {}
        for i, n in enumerate(nums):
            m = target - n
            if m in d:
                return [d[m], i]
            else:
                d[n] = i
```

## Testcase
```python 

s = Solution()
nums = [2,7,11,15]
target = 9

assert s.twoSum(nums, target) == [0, 1]
```