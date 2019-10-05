```python

class Solution(object):
    def fourSum(self, nums: list, target: int) -> list:
        if len(nums) < 4:
            return []
        res = []
        nums.sort()
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            if nums[i] + sum(nums[i + 1:i + 3 + 1]) > target:
                break
            if nums[i] + sum(nums[-1:-3 - 1:-1]) < target:
                continue

            for j in range(i + 1, len(nums)):
                if j > 0 and nums[j] == nums[j - 1]:
                    continue
                if nums[i] + nums[j] + sum(nums[j + 1:j + 2 + 1]) > target:
                    break
                if nums[i] + nums[j] + sum(nums[-1:-2 - 1:-1]) < target:
                    continue
                k = j + 1
                h = len(nums) - 1
                while k < h:
                    s = nums[i] + nums[j] + nums[k] + nums[h]

                    if s == target:
                        if [nums[i], nums[j], nums[k], nums[h]] not in res:
                            res.append([nums[i], nums[j], nums[k], nums[h]])

                        k += 1
                        h -= 1
                        while k < h and nums[k] == nums[k - 1]: k += 1
                        while k < h and nums[h] == nums[h + 1]: h -= 1

                    elif s > target:
                        h -= 1
                    else:
                        k += 1
        return res
```