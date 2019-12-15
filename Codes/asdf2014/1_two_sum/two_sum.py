# https://leetcode.com/problems/two-sum/


# 从 nums 中找到两个数，满足两数之和为 target
def two_sum(nums, target):
    nums_len = len(nums) 
    if nums_len < 1: 
        return False
    cache = {}
    for i in range(nums_len):
        n = nums[i]
        if n in cache:
            # 2. 当前值 n 在 Map 中找到对应的 key 则拿出对应的 value，因为此时 n + key 刚好等于 target
            return [cache[n], i]
        else:
            # 1. 当前值 n 与目标值 target 的差值作为 Map 的 key，而下标作为 value
            cache[target - n] = i


assert two_sum([2, 7, 11, 15], 9) == [0, 1]
assert two_sum([4, 7, 0, 3], 3) == [2, 3]
