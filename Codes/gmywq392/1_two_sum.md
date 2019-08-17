

使用 python 的 dict 存储已出现的值及其索引：

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        slots = {}
        for index in range(len(nums)):
            rest = target - nums[index]
            if rest in slots:
                return [slots[rest], index]
            slots[nums[index]] = index
```