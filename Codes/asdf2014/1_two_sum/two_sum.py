# https://leetcode-cn.com/problems/two-sum/

# Given an array of integers, return indices of the two numbers such that they add up to a specific target.
#
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
#
# Example:
# Given nums = [2, 7, 11, 15], target = 9,
#
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].
#
# Related Topics Array Hash Table
#
# 时间复杂度：O(N)
# 空间复杂度：O(N)
# 其中 N 是数组中的元素数量
# 对于每一个元素 x，我们可以 O(1) 地寻找 target - x
# 空间存储上，主要是哈希表的开销


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
