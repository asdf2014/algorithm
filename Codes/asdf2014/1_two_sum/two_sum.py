# https://leetcode.com/problems/two-sum/


def two_sum(nums, target):
    nums_len = len(nums)
    if nums_len < 1:
        return False
    cache = {}
    for i in range(nums_len):
        n = nums[i]
        if n in cache:
            return [cache[n], i]
        else:
            cache[target - n] = i


assert two_sum([2, 7, 11, 15], 9) == [0, 1]
